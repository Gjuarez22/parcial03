package sv.edu.ufg.clinica.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmployeSalarioCode {
    private Integer idEmploye;
    private String codeEmploye;
    private String salary;
}
