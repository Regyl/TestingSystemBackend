package rut.miit.testingsystem.test;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.subject.Subject;
import rut.miit.testingsystem.test.dto.request.TestDTOCreateRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "test")
@Data
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue
    @NotNull
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectId;

    @NotNull
    private String name;

    private LocalDateTime startsAt;

    private LocalDateTime endsAt;

    private Integer term; //Семестр, для которого доступен тест

    public Test(TestDTOCreateRequest createRequest, Subject subject) {
        this.subjectId=subject;
        this.name= createRequest.getName();
        this.startsAt= createRequest.getStartsAt() != null ?
                LocalDateTime.of(createRequest.getStartsAt(), LocalTime.MIN) : null;
        this.endsAt= createRequest.getEndsAt() != null ?
                LocalDateTime.of(createRequest.getEndsAt(), LocalTime.MAX) : null;
        this.term=createRequest.getTerm();
    }
}
