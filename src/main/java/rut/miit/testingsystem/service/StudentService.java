package rut.miit.testingsystem.service;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.entity.Student;
import rut.miit.testingsystem.entity.User;
import rut.miit.testingsystem.exception.EntityNotFoundException;
import rut.miit.testingsystem.exception.StudentNotFoundException;
import rut.miit.testingsystem.repository.StudentRepository;
import rut.miit.testingsystem.api.controller.dto.request.request.StudentDtoGroupUpdateRequest;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentGroupService groupService;

    public StudentService(StudentRepository repository, StudentGroupService groupService) {
        this.repository = repository;
        this.groupService = groupService;
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findById(UUID id) {
        return repository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void updateStatus(UUID studentId) {
        Student student = findById(studentId);
        student.setIsAgreed(true);
        repository.save(student);
    }

    public void updateGroup(StudentDtoGroupUpdateRequest updateRequest) { //TODO: move to repository @Query
        List<Student> students = repository.findAllById(updateRequest.getStudentIds());
        students.forEach(student -> student.setGroup(groupService.findById(updateRequest.getGroupId())));
        repository.saveAll(students);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Student findByUser(User user) {
        return repository.findByUser(user)
                .orElseThrow(() -> new EntityNotFoundException(user.getUsername(), User.class));
    }
}
