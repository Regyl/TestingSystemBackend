package rut.miit.testingsystem.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "answers")
public class Question {
    @Id
    @GeneratedValue
    private UUID id;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(columnDefinition = "TEXT")
    private String additionalInfo;

    @ManyToOne
    @JoinColumn(name = "test_id")
    @NotNull
    private Test test;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            mappedBy = "question")
    private Set<Answer> answers;
}
