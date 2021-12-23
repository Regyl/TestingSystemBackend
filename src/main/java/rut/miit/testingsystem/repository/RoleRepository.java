package rut.miit.testingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rut.miit.testingsystem.entity.enums.Authorities;
import rut.miit.testingsystem.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Authorities> {
}
