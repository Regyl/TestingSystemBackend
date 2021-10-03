package rut.miit.testingsystem.auth.authority;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import rut.miit.testingsystem.auth.user.User;
import rut.miit.testingsystem.auth.user.dto.request.UserDTORegisterRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    private Authorities authority;

    @Transient
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Role(UserDTORegisterRequest userDTORegisterRequest) {
        this.authority= userDTORegisterRequest.getAuthority();
    }

    public String getAuthority() {
        return authority.toString();
    }
}
