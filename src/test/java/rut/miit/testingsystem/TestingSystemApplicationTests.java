package rut.miit.testingsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class TestingSystemApplicationTests {

    @LocalServerPort
    private static Integer port;

    @Test
    void contextLoads() {
    }

    @Test
    void isPortNotNull() {
        assertNotNull(port);
    }

}
