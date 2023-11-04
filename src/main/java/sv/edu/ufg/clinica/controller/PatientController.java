package sv.edu.ufg.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.clinica.model.Patient;
import sv.edu.ufg.clinica.service.IPatientService;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

     @Autowired
    private IPatientService service;

     @GetMapping
     public List<Patient> findAll(){

         return  service.findAll();
     }


    @GetMapping("/{id}")
    public Patient findById(@PathVariable("id") Integer id){

        return  service.findOneById(id);
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient){
         return service.save(patient);
    }

    @DeleteMapping("/{id}")
    public void  deleteById(@PathVariable("id") Patient patient){
         service.delete(patient);
    }


}
