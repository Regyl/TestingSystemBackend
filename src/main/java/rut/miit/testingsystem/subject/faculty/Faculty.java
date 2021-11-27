package rut.miit.testingsystem.subject.faculty;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

@Getter
public enum Faculty {

    MathematicsAndMechanics("Математика и механика"),
    ComputerAndInformationScience("Информатика и вычислительная техника");

    Faculty(String name) {
        this.name=name;
    }

    public static Stream<Faculty> stream() {
        return Stream.of(Faculty.values());
    }

    private final String name;

}
