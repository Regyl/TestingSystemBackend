package rut.miit.testingsystem.student.result;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentResultRepository extends JpaRepository<StudentResult, UUID> {
}
