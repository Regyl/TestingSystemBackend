package rut.miit.testingsystem.integration;

import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithAnonymousUser;
import rut.miit.testingsystem.entity.enums.Authorities;
import rut.miit.testingsystem.api.controller.dto.request.UserDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WithAnonymousUser
class AuthorisationTest extends AbstractIntegrationTest {

    @Test
    void registration() throws Exception {
        UserDto dto = podamFactory.manufacturePojo(UserDto.class);
        dto.setAuthority(Authorities.Administrator);
        mvc.perform(post("/register").contentType(JSON).content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }
}
