package sv.edu.ufg.clinica.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmployeRDto {
    private Integer idEmploye;
    @NotNull
    private String reason_inactivity;
}
