package rut.miit.testingsystem.student;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import rut.miit.testingsystem.auth.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, UUID> {

    List<Student> findAll();

    List<Student> findAllById(Iterable<UUID> ids);

    Optional<Student> findByUser(User user);
}
