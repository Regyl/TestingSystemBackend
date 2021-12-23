package rut.miit.testingsystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import rut.miit.testingsystem.entity.enums.Authorities;

import javax.persistence.*;
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

    public Role(Authorities authority) {
        this.authority= authority;
    }

    @Override
    public String getAuthority() {
        return authority.toString();
    }
}
