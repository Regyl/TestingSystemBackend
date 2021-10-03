package rut.miit.testingsystem.auth;

import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.auth.user.dto.request.UserDTORegisterRequest;

@RestController
public class UserController {
    final UserService service;
    public UserController(UserService service) {
        this.service=service;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@RequestBody UserDTORegisterRequest userDTORegisterRequest) {
        service.saveUser(userDTORegisterRequest);
    }
}
