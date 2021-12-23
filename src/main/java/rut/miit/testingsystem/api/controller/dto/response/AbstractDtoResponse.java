package rut.miit.testingsystem.api.controller.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AbstractDtoResponse {

    private LocalDateTime timestamp;

    protected AbstractDtoResponse() {
        this.timestamp=LocalDateTime.now();
    }
}
