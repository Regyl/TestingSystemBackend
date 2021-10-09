package rut.miit.testingsystem.test.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.test.Test;

@Data
@NoArgsConstructor
public class TestDTOCreateResponse extends ObjectDTOCreateResponse {
    private Test test;

    public TestDTOCreateResponse(Test test) {
        super();
        this.test=test;
    }
}
