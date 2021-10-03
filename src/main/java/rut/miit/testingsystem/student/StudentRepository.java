package rut.miit.testingsystem.student;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, UUID> {

    List<Student> findAll();

    List<Student> findAllByGroupIdIsNull();

    List<Student> findAllById(Iterable<UUID> ids);
}
