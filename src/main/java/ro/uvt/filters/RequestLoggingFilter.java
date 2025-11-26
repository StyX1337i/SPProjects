package ro.uvt.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class RequestLoggingFilter implements Filter {

    private static final String LOG_FILE = "request.log";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String method = httpRequest.getMethod();
        String uri = httpRequest.getRequestURI();
        long startTime = System.currentTimeMillis();

        logRequest("BEFORE", method, uri, LocalDateTime.now());

        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;
        logRequest("AFTER", method, uri, LocalDateTime.now(), httpResponse.getStatus(), duration);
    }

    private void logRequest(String phase, String method, String uri, LocalDateTime timestamp) {
        logRequest(phase, method, uri, timestamp, null, null);
    }

    private void logRequest(String phase, String method, String uri, LocalDateTime timestamp, Integer status, Long duration) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(String.format("[%s] %s - %s %s", timestamp, phase, method, uri));
            if (status != null) {
                writer.println(String.format("  Status: %d, Duration: %d ms", status, duration));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

