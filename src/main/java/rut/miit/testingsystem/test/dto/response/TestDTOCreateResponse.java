package rut.miit.testingsystem.test.dto.response;

import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.test.Test;

public class TestDTOCreateResponse extends ObjectDTOCreateResponse {
    private Test test;

    public TestDTOCreateResponse(Test test) {
        super();
        this.test=test;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
