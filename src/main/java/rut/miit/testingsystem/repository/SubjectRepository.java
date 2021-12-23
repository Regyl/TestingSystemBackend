package rut.miit.testingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rut.miit.testingsystem.entity.Subject;
import rut.miit.testingsystem.entity.enums.Faculty;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {

    List<Subject> findAllByFaculty(Faculty faculty);

}
