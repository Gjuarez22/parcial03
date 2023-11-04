package sv.edu.ufg.clinica.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer idPatient;

    @Column(length = 70, nullable = false)
    private String firstName;

    @Column(length = 70, nullable = false)
    private String lastName;

    @Column(length = 9, nullable = false)
    private String dui;


    @Column(length = 150)
    private String address;


    @Column(length = 8, nullable = false)
    private String phone;


    @Column(length = 55, nullable = false)
    private String email;


}
