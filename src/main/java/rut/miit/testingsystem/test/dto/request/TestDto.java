package rut.miit.testingsystem.test.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TestDto {
    @NotNull
    private UUID subjectId;

    @NotNull
    private Integer term;

    private LocalDate startsAt;

    private LocalDate endsAt;

    @NotNull
    private String name;
}
