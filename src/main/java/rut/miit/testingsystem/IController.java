package rut.miit.testingsystem;

import java.util.List;
import java.util.UUID;

public interface IController {
    List<? extends Object> findAll();

    Object findById(UUID id);

    void deleteById(UUID id);

}
