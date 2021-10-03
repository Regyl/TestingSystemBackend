package rut.miit.testingsystem.auth.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import rut.miit.testingsystem.auth.authority.Role;
import rut.miit.testingsystem.auth.user.dto.request.UserDTORegisterRequest;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(columnDefinition = "BOOLEAN default true")
    private Boolean enabled = true;

    @Column(columnDefinition = "BOOLEAN default true")
    private Boolean accountNonExpired = true;

    @Column(columnDefinition = "BOOLEAN default true")
    private Boolean accountNonLocked = true;

    @Column(columnDefinition = "BOOLEAN default true")
    private Boolean credentialsNonExpired = true;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> authorities = new HashSet<>(3);

    public User(UserDTORegisterRequest userDTORegisterRequest) {
        this.username= userDTORegisterRequest.getLogin();
        this.password= new BCryptPasswordEncoder().encode(userDTORegisterRequest.getPassword());
        this.authorities.add(new Role(userDTORegisterRequest));
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    public boolean isEnabled() {
        return enabled;
    }

}
