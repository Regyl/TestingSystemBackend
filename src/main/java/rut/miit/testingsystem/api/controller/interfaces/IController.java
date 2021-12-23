package rut.miit.testingsystem.api.controller.interfaces;

import rut.miit.testingsystem.api.controller.dto.response.AbstractDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IController {
    List<? extends AbstractDtoResponse> findAll();

    Object findById(UUID id);

    void deleteById(UUID id);

}
