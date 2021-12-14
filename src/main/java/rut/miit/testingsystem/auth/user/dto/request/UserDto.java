package rut.miit.testingsystem.auth.user.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.auth.authority.Authorities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
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
