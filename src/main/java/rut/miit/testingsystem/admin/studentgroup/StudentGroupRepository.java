package rut.miit.testingsystem.admin.studentgroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, UUID> {
}
