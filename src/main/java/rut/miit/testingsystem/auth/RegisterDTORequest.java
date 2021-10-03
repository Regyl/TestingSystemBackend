package rut.miit.testingsystem.auth;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class RegisterDTORequest {
    @NotEmpty
    private String login;

    @NotEmpty
    @Min(8)
    private String password;

    @NotEmpty
    private Authorities authority;
}
