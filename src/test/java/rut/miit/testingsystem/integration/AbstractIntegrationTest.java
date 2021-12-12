package rut.miit.testingsystem.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@AutoConfigureMockMvc
@SpringBootTest
abstract class AbstractIntegrationTest {

    @Autowired
    protected MockMvc mvc;

    protected static PodamFactory podamFactory;

    @Autowired
    protected ObjectMapper mapper;

    protected static final MediaType JSON = MediaType.APPLICATION_JSON;

    static {
        podamFactory = new PodamFactoryImpl();
    }
}
