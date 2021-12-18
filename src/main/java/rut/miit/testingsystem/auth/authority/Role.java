package rut.miit.testingsystem.auth.authority;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import rut.miit.testingsystem.auth.user.User;
import rut.miit.testingsystem.auth.user.dto.request.UserDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @Enumerated(EnumType.STRING)
    private Authorities authority;

    @Transient
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Role(UserDto userDTORegisterRequest) {
        this.authority= userDTORegisterRequest.getAuthority();
    }

    @Override
    public String getAuthority() {
        return authority.toString();
    }
}
