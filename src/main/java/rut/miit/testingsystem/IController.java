package rut.miit.testingsystem;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IController {
    public List<?> findAll();

    public <T> T findById(UUID id);

    public void deleteById(UUID id);

}
