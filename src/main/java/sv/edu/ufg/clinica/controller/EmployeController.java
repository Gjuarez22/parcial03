package sv.edu.ufg.clinica.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sv.edu.ufg.clinica.dto.DepartamentDTO;
import sv.edu.ufg.clinica.dto.EmployeDTO;
import sv.edu.ufg.clinica.dto.EmployeRDto;
import sv.edu.ufg.clinica.dto.EmployeSalarioCode;
import sv.edu.ufg.clinica.model.Departament;
import sv.edu.ufg.clinica.model.Employe;
import sv.edu.ufg.clinica.service.IDepartamentService;
import sv.edu.ufg.clinica.service.IEmployeService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Employe")
public class EmployeController {

    @Autowired
    private IEmployeService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EmployeDTO>> findAll() {
        List<EmployeDTO> list = service.findAll().stream().map(p -> mapper.map(p, EmployeDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeDTO> findById(@PathVariable("id") Integer id) {
        EmployeDTO dtoResponse;
        Employe obj = service.findOneById(id);
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            dtoResponse = mapper.map(obj, EmployeDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EmployeDTO dto) {
        Employe p = service.save(mapper.map(dto, Employe.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdEmploye()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Employe> update(@Valid @RequestBody EmployeDTO dto) {
        Employe obj = service.findOneById(dto.getIdEmploye());
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service.update(mapper.map(dto, Employe.class)), HttpStatus.OK);
    }

    @PostMapping("/inactivar")
    public ResponseEntity<EmployeDTO> inactivar(@Valid @RequestBody EmployeRDto r) {
        EmployeDTO dtoResponse;
        Employe em = service.findOneById(r.getIdEmploye());
        em.setActive(false);
        em.setReason_inactivity(r.getReason_inactivity());
        Employe p = service.update(em);

        dtoResponse = mapper.map(p, EmployeDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping("/salario")
    public ResponseEntity<EmployeDTO> salario(@Valid @RequestBody EmployeSalarioCode r) {
        EmployeDTO dtoResponse;
        double iss = 0.03;
        double afp = 0.0725;
        double impuestoTotal = iss + afp;
        double salario = Double.parseDouble(r.getSalary());
        double salarioLiquido = salario - (impuestoTotal * salario);
        String guardar = String.valueOf(salarioLiquido);

        Employe em = service.findOneById(r.getIdEmploye());
        em.setCodeEmploye(r.getCodeEmploye());
        em.setSalary(guardar);
        Employe p = service.update(em);

        dtoResponse = mapper.map(p, EmployeDTO.class);

        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }


}
