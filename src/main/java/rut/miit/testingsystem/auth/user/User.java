package rut.miit.testingsystem.auth.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.auth.user.dto.request.UserDTORegisterRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(columnDefinition = "BOOLEAN default true")
    private Boolean enabled=true;

    public User(UserDTORegisterRequest userDTORegisterRequest) {
        this.username= userDTORegisterRequest.getLogin();
        this.password= userDTORegisterRequest.getPassword();
    }
}
