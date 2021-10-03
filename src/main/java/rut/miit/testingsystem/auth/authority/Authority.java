package rut.miit.testingsystem.auth.authority;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.auth.user.dto.request.UserDTORegisterRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
public class Authority { //TODO: add constraint for value "authority"
    @Id
    @Column
    private String username;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    private Authorities authority;

    public Authority(UserDTORegisterRequest userDTORegisterRequest) {
        this.username= userDTORegisterRequest.getLogin();
        this.authority= userDTORegisterRequest.getAuthority();
    }
}
