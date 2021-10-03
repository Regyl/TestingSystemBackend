package rut.miit.testingsystem;

import java.time.LocalDateTime;

public abstract class ObjectDTOCreateResponse {
    private LocalDateTime timestamp;

    protected ObjectDTOCreateResponse() {
        this.timestamp=LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
