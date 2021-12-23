package rut.miit.testingsystem.api.controller.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TestDto {
    @NotNull
    private UUID subjectId;

    @NotNull
    @Min(1)
    @Max(6)
    private Integer term;

    private LocalDate startsAt;

    private LocalDate endsAt;

    @NotNull
    private String name;
}
