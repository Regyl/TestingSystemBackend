package rut.miit.testingsystem.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MvcResult;
import rut.miit.testingsystem.student.dto.request.StudentDto;
import rut.miit.testingsystem.student.dto.response.StudentDtoResponse;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@WithUserDetails("admin")
class StudentTest extends AbstractIntegrationTest {

    @Test
    void findAll() throws Exception {
        MvcResult result = mvc.perform(get("/students/")).andExpect(status().isOk()).andReturn();
        List<StudentDtoResponse> responses = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        assertTrue(responses.size() > 0);
    }

    @Test
    void createDelete() throws Exception {
        StudentDto dto = podamFactory.manufacturePojo(StudentDto.class);
        MvcResult result = mvc.perform(post("/students/").contentType(JSON).content(mapper.writeValueAsString(dto))).andExpect(status().isCreated()).andReturn();
        StudentDtoResponse response = mapper.readValue(result.getResponse().getContentAsString(), StudentDtoResponse.class);
        assertEquals(dto.getFirstName(), response.getFirstName());

        mvc.perform(delete("/students/{id}", response.getId())).andExpect(status().isOk());
    }


}
