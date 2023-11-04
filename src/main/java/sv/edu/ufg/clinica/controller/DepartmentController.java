package sv.edu.ufg.clinica.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sv.edu.ufg.clinica.dto.DepartamentDTO;
import sv.edu.ufg.clinica.dto.MunicipalityDTO;
import sv.edu.ufg.clinica.model.Departament;
import sv.edu.ufg.clinica.service.IDepartamentService;
import sv.edu.ufg.clinica.service.IMunicipalityService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
    @RequestMapping("/Department")
public class DepartmentController {

    @Autowired
    private IDepartamentService service;

    @Autowired
    private IMunicipalityService serviceM;

    @Autowired
    private ModelMapper mapper;

        @GetMapping
        public ResponseEntity<List<DepartamentDTO>> findAll() {
            List<DepartamentDTO> list = service.findAll().stream().map(p -> mapper.map(p, DepartamentDTO.class)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

    @GetMapping("/{id}")
    public ResponseEntity<Departament> findById(@PathVariable("id") Integer id) {

        Departament dtoResponse;
        Departament obj = service.findOneById(id);
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            dtoResponse = mapper.map(obj, Departament.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DepartamentDTO dto) {
        Departament p = service.save(mapper.map(dto, Departament.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdDepartament()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Departament> update(@Valid @RequestBody DepartamentDTO dto) {
        Departament obj = service.findOneById(dto.getIdDepartament());
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service.update(mapper.map(dto, Departament.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        Departament obj = service.findOneById(id);
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            service.delete(obj);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
