package rut.miit.testingsystem.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import rut.miit.testingsystem.subject.dto.request.SubjectDto;
import rut.miit.testingsystem.subject.dto.response.SubjectDtoResponse;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@WithUserDetails(value = "admin")
class SubjectTest extends AbstractIntegrationTest {

    private static final Logger log = Logger.getLogger(SubjectTest.class.getName());

    @Test
    void findAll() throws Exception {
        MvcResult result = mvc.perform(get("/subjects/")).andExpect(status().isOk()).andReturn();
        List<SubjectDtoResponse> responses = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});
        assertFalse(responses.size() < 1, "There must be almost one subject!");
    }

    @Test
    void createDelete() throws Exception {
        SubjectDto dto = podamFactory.manufacturePojo(SubjectDto.class);
        MvcResult result = mvc.perform(post("/subjects/").contentType(JSON).content(mapper.writeValueAsString(dto))).andExpect(status().isCreated()).andReturn();
        SubjectDtoResponse response = mapper.readValue(result.getResponse().getContentAsString(), SubjectDtoResponse.class);
        assertEquals(dto.getName(), response.getName());

        mvc.perform(delete("/subjects/{id}", response.getId())).andExpect(status().isOk());
    }

    /*@Test
    void update() throws Exception {
        MvcResult result = mvc.perform(get("/subjects/")).andExpect(status().isOk()).andReturn();
        List<SubjectDtoResponse> responses = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});

    }*/
}
