package rut.miit.testingsystem.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MvcResult;
import rut.miit.testingsystem.api.controller.dto.response.QuestionDtoResponse;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@WithUserDetails("professor")
class QuestionTest extends AbstractIntegrationTest {

    @Test
    void findAll() throws Exception {
        MvcResult result = mvc.perform(get("/questions/")).andExpect(status().isOk()).andReturn();
        List<QuestionDtoResponse> responses = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        assertTrue(responses.size() > 0);
    }
}
