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
public class Employe {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmploye;
    @Column(nullable = true, length = 10)
    private String codeEmploye;
    @Column(nullable = false, length = 50)
    private String firsName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 50)
    private String gender;
    @Column(nullable = false, length = 50)
    private String address;
    @Column(nullable = true, length = 50)
    private String phone;
    @Column(nullable = true, length = 10)
    private String salary;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = true, length = 100)
    private String reason_inactivity;
}
