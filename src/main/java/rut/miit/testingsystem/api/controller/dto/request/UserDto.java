package rut.miit.testingsystem.api.controller.dto.request;

import lombok.Data;
import rut.miit.testingsystem.entity.enums.Authorities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
    @NotEmpty
    private String login;

    @NotEmpty
    @Min(8)
    private String password;

    @NotEmpty
    private Authorities authority;
}
