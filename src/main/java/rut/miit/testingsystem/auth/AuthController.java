package rut.miit.testingsystem.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.auth.user.dto.request.UserDTORegisterRequest;

@RestController
public class AuthController {
    final AuthService service;
    public AuthController(AuthService service) {
        this.service=service;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@RequestBody UserDTORegisterRequest userDTORegisterRequest) {
        service.register(userDTORegisterRequest);
    }
}
