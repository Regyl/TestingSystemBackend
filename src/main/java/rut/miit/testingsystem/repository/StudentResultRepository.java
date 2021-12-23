package rut.miit.testingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rut.miit.testingsystem.entity.StudentResult;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentResultRepository extends JpaRepository<StudentResult, UUID> {

    @Query("select r from StudentResult r group by r.student.group")
    List<StudentResult> findAllGroupByStudentGroup();
}
