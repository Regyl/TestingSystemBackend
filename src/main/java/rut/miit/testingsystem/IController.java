package rut.miit.testingsystem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public interface IController {
    public List<?> findAll();

    public <T> T findById(UUID id);

    public void deleteById(UUID id);

}
