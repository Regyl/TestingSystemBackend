package rut.miit.testingsystem.api.controller.dto.response.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.api.controller.dto.response.AbstractDtoResponse;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentGroupDtoResponse extends AbstractDtoResponse {

    private UUID id;

    private String shortName;

    private Integer number;

}
