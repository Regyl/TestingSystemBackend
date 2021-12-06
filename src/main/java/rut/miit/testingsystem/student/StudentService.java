package rut.miit.testingsystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.StudentNotFoundException;
import rut.miit.testingsystem.student.dto.request.StudentDto;
import rut.miit.testingsystem.student.dto.request.StudentDtoGroupUpdateRequest;
import rut.miit.testingsystem.student.group.StudentGroupService;

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

    public List<Student> findByGroupIdIsNull() {
        return repository.findAllByGroupIdIsNull();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
