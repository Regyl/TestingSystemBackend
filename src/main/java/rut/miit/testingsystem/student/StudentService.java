package rut.miit.testingsystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.StudentNotFoundException;
import rut.miit.testingsystem.student.dto.request.StudentDTOCreateRequest;
import rut.miit.testingsystem.student.dto.request.StudentDTOGroupUpdateRequest;
import rut.miit.testingsystem.student.group.StudentGroupService;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository=repository;
    }
    StudentGroupService groupService;
    @Autowired
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findById(UUID id) {
        return repository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public Student create(StudentDTOCreateRequest createRequest) {
        return repository.save(new Student(createRequest));
    }

    public void updateStatus(UUID studentId) {
        Student student = findById(studentId);
        student.setIsAgreed(true);
        repository.save(student);
    }

    public void updateGroup(StudentDTOGroupUpdateRequest updateRequest) { //TODO: move to repository @Query
        List<Student> students = repository.findAllById(updateRequest.getStudentIds());
        students.forEach(student -> student.setGroupId(groupService.findById(updateRequest.getGroupId())));
        repository.saveAll(students);
    }

    public List<Student> findByGroupIdIsNull() {
        return repository.findAllByGroupIdIsNull();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
