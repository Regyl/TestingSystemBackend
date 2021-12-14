package rut.miit.testingsystem;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AbstractDtoResponse {

    private LocalDateTime timestamp;

    protected AbstractDtoResponse() {
        this.timestamp=LocalDateTime.now();
    }
}
