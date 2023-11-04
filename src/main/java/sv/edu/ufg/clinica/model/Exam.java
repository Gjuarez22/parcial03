package sv.edu.ufg.clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exam {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExam;

    @Column(nullable = false, length = 50)
        private String name;

    @Column(nullable = false, length = 150)
    private String description;
}