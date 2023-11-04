package sv.edu.ufg.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Municipality {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMunicipality;

    @Column(nullable = true, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "idDepartament", nullable = false)
    private Departament departament;
}
