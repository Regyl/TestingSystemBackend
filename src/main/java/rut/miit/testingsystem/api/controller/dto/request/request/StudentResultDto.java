package rut.miit.testingsystem.api.controller.dto.request.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
public class StudentResultDto {

    @NotNull
    private List<UUID> answers;

    @NotNull
    private UUID testId;
}
