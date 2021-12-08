package rut.miit.testingsystem.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(UUID id, Class<?> entityClass) {
        super(EntityNotFoundException.obtainMessage(id.toString(), entityClass));
    }

    public EntityNotFoundException(String id, Class<?> entityClass) {
        super(EntityNotFoundException.obtainMessage(id, entityClass));
    }

    private static String obtainMessage(String id, Class<?> entityClass) {
        return String.format("Entity of type %s with id %s not found", entityClass.getSimpleName(), id);
    }

}
