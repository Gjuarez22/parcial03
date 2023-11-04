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
import sv.edu.ufg.clinica.model.Municipality;
import sv.edu.ufg.clinica.service.IDepartamentService;
import sv.edu.ufg.clinica.service.IMunicipalityService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
    @RequestMapping("/Municipality")
public class MunicipalityController {

    @Autowired
    private IMunicipalityService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MunicipalityDTO>> findAll() {
        List<MunicipalityDTO> list = service.findAll().stream()
                .map(Municipality -> {
                    MunicipalityDTO MunicipalityDTO = mapper.map(Municipality, MunicipalityDTO.class);
                    // Mapea manualmente la relación Position
                    MunicipalityDTO.setIdDepartament(mapper.map(Municipality.getDepartament(),DepartamentDTO.class));
                    return MunicipalityDTO;
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipalityDTO> findById(@PathVariable("id") Integer id) {
        MunicipalityDTO dtoResponse;
        Municipality obj = service.findOneById(id);
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            dtoResponse = mapper.map(obj, MunicipalityDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MunicipalityDTO dto) {
        Municipality p = service.save(mapper.map(dto, Municipality.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdMunicipality()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Municipality> update(@Valid @RequestBody MunicipalityDTO dto) {
        Municipality obj = service.findOneById(dto.getIdMunicipality());
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service.update(mapper.map(dto, Municipality.class)), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        Municipality obj = service.findOneById(id);
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            service.delete(obj);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
