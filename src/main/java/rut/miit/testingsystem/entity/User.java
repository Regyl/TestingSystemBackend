package rut.miit.testingsystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import rut.miit.testingsystem.api.controller.dto.request.UserDto;

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

    @ManyToMany(fetch = FetchType.EAGER) //Если ставить lazy падает с LazyInitializationException
    private Set<Role> authorities = new HashSet<>(3);

    public User(UserDto userDTORegisterRequest, String password) {
        this.username= userDTORegisterRequest.getLogin();
        this.password= password;
        this.authorities.add(new Role(userDTORegisterRequest.getAuthority()));
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
