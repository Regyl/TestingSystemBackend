package rut.miit.testingsystem.auth;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rut.miit.testingsystem.auth.user.dto.request.UserDTORegisterRequest;

@Tag(name = "Authentication")

@RestController
public class AuthController {
    final AuthService service;
    public AuthController(AuthService service) {
        this.service=service;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@RequestBody UserDTORegisterRequest userDTORegisterRequest) {
        service.saveUser(userDTORegisterRequest);
    }
}
