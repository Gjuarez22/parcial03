package sv.edu.ufg.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.clinica.model.Exam;
import sv.edu.ufg.clinica.model.Patient;
import sv.edu.ufg.clinica.service.IExamService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private IExamService service;

    @PostMapping
    public Exam save(@RequestBody Exam exam){
        return service.save(exam);
    }
    @GetMapping
    public List<Exam> findAll(){

        return  service.findAll();
    }

    @GetMapping("/{id}")
    public Exam findById(@PathVariable("id") Integer id){

        return  service.findOneById(id);
    }

    @DeleteMapping("/{id}")
    public void  deleteById(@PathVariable("id") Exam exam){
        service.delete(exam);
    }

}
