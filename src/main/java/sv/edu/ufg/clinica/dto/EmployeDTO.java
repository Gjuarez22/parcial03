package sv.edu.ufg.clinica.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import sv.edu.ufg.clinica.model.Municipality;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class EmployeDTO {

    private Integer idEmploye;
    private String codeEmploye;
    @NotNull
    private String firsName;
    @NotNull
    private String lastName;
    @NotNull
    private String gender;
    @NotNull
    private String addressComp;
    private String phone;
    private String salary;
    @NotNull
    private boolean active;
    private String reason_inactivity;
    private Municipality municipality;
}
