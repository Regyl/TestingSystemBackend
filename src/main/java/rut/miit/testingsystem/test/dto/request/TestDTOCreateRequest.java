package rut.miit.testingsystem.test.dto.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public class TestDTOCreateRequest {
    @NotNull
    private UUID subjectId;

    @NotNull
    private Integer term;

    private LocalDate startsAt;

    private LocalDate endsAt;

    @NotNull
    private String name;

    public TestDTOCreateRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(LocalDate endsAt) {
        this.endsAt = endsAt;
    }

    public LocalDate getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(LocalDate startsAt) {
        this.startsAt = startsAt;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }
}
