package ro.uvt.commands;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CommandExecutor {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public Object execute(Command command) {
        return command.execute();
    }

    public void executeAsync(Command command, String requestId, Map<String, RequestStatus> requestStatuses) {
        executorService.submit(() -> {
            try {
                requestStatuses.put(requestId, new RequestStatus("PROCESSING", null));
                Object result = command.execute();
                requestStatuses.put(requestId, new RequestStatus("COMPLETED", result));
            } catch (Exception e) {
                requestStatuses.put(requestId, new RequestStatus("FAILED", e.getMessage()));
            }
        });
    }
}

