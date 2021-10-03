package rut.miit.testingsystem.professor.test;

import rut.miit.testingsystem.professor.test.dto.request.TestDTOCreateRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue
    @Column
    @NotNull
    private UUID id;

    @Column
    @NotNull
    private UUID subjectId;

    @Column
    @NotNull
    private String name;

    @Column
    private LocalDateTime startsAt;

    @Column
    private LocalDateTime endsAt;

    @Column
    private Integer term; //Семестр, для которого доступен тест

    public Test() {}

    public Test(TestDTOCreateRequest createRequest) {
        this.subjectId=createRequest.getSubjectId();
        this.name= createRequest.getName();
        this.startsAt= createRequest.getStartsAt() != null ?
                LocalDateTime.of(createRequest.getStartsAt(), LocalTime.MIN) : null;
        this.endsAt= createRequest.getEndsAt() != null ?
                LocalDateTime.of(createRequest.getEndsAt(), LocalTime.MAX) : null;
        this.term=createRequest.getTerm();
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public LocalDateTime getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(LocalDateTime endsAt) {
        this.endsAt = endsAt;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(LocalDateTime startsAt) {
        this.startsAt = startsAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
