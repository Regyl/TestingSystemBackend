package rut.miit.testingsystem;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class ObjectDTOCreateResponse {
    private LocalDateTime timestamp;

    protected ObjectDTOCreateResponse() {
        this.timestamp=LocalDateTime.now();
    }
}
