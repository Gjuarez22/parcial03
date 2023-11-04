package sv.edu.ufg.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.edu.ufg.clinica.service.IDepartamentService;

@RestController
@RequestMapping("/Department")
public class DepartmentController {

    @Autowired
    private IDepartamentService service;


    @GetMapping
    public ResponseEntity<List<PosicionDTO>> findAll() {
        List<PosicionDTO> list = service.findAll().stream().map(p -> mapper.map(p, PosicionDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
