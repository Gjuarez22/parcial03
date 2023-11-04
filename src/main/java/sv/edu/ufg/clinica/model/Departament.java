package sv.edu.ufg.clinica.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departament {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartament;

    @Column(nullable = true, length = 50)
    private String name;
}
