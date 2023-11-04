package sv.edu.ufg.clinica.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class DepartamentDTO {

    private Integer idDepartament;

    @NotNull
    @Size(min = 3, message = "{name.size}")
    private String name;
}
