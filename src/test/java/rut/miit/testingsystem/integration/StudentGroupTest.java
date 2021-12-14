package rut.miit.testingsystem.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MvcResult;
import rut.miit.testingsystem.student.group.dto.request.StudentGroupDto;
import rut.miit.testingsystem.student.group.dto.response.StudentGroupDtoResponse;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@WithUserDetails("admin")
class StudentGroupTest extends AbstractIntegrationTest {

    @Test
    void findAll() throws Exception {
        mvc.perform(get("/students/groups/")).andExpect(status().isOk());
    }

    @Test
    void createDelete() throws Exception {
        StudentGroupDto dto = podamFactory.manufacturePojo(StudentGroupDto.class);
        MvcResult result = mvc.perform(post("/students/groups/").contentType(JSON).content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andReturn();
        StudentGroupDtoResponse response = mapper.readValue(result.getResponse().getContentAsString(), StudentGroupDtoResponse.class);
        assertEquals(dto.getShortName(), response.getShortName());

        mvc.perform(delete("/students/groups/{id}", response.getId())).andExpect(status().isOk());
    }
}
