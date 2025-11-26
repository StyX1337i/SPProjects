package ro.uvt.commands;

public class RequestStatus {
    private String status;
    private Object result;

    public RequestStatus(String status, Object result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public Object getResult() {
        return result;
    }
}

