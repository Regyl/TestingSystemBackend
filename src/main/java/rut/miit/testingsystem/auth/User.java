package rut.miit.testingsystem.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(columnDefinition = "BOOLEAN default true")
    private Boolean enabled=true;

    public User(RegisterDTORequest registerDTORequest) {
        this.username= registerDTORequest.getLogin();
        this.password= registerDTORequest.getPassword();
    }
}
