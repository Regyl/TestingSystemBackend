package rut.miit.testingsystem.auth;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
public class Authority { //TODO: add constraint for value "authority"

    @Id
    @Column
    private String authority;

    @Column
    private String username;

    public Authority(RegisterDTORequest registerDTORequest) {
        this.username=registerDTORequest.getLogin();
        this.authority="ROLE_ADMIN"; //TODO: switch to authorities
    }
}
