package sv.edu.ufg.clinica.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DepartamentDTO {

    private Integer idDepartament;

    @NotNull
    @Size(min = 3, message = "{name.size}")
    private String name;
}
