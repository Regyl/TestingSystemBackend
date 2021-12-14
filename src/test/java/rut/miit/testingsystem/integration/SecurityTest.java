package rut.miit.testingsystem.integration;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

class SecurityTest extends AbstractIntegrationTest {


    @WithUserDetails(value = "admin")
    @Test
    void securityAdminTests() throws Exception {
        mvc.perform(get("/subjects/")).andExpect(status().isOk());
        mvc.perform(get("/students/")).andExpect(status().isOk());
        mvc.perform(get("/students/groups/")).andExpect(status().isOk());
        mvc.perform(get("/students/results/")).andExpect(status().isOk());
        mvc.perform(get("/tests/")).andExpect(status().isForbidden());
    }

    @WithUserDetails(value = "professor")
    @Test
    void securityProfessorTests() throws Exception {
        mvc.perform(get("/tests/")).andExpect(status().isOk());
        mvc.perform(get("/subjects/")).andExpect(status().isOk());
        mvc.perform(get("/students/")).andExpect(status().isForbidden());
        mvc.perform(get("/students/groups/")).andExpect(status().isForbidden());
        mvc.perform(get("/students/results/")).andExpect(status().isForbidden());
    }

    @WithUserDetails(value = "eug")
    @Test
    void securityStudentTests() throws Exception {
        mvc.perform(get("/subjects/")).andExpect(status().isOk());
//        mvc.perform(get("/students/")).andExpect(status().isForbidden());
        mvc.perform(get("/students/groups/")).andExpect(status().isForbidden());
//        mvc.perform(get("/students/results/")).andExpect(status().isForbidden());
        mvc.perform(get("/tests/")).andExpect(status().isOk());
    }
}
