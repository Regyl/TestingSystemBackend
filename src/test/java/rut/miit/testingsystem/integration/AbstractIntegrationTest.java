package rut.miit.testingsystem.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
abstract class AbstractIntegrationTest {

    protected static final MediaType JSON = MediaType.APPLICATION_JSON;

    protected static PodamFactory podamFactory;

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper mapper;

    static {
        podamFactory = new PodamFactoryImpl();
    }
}
