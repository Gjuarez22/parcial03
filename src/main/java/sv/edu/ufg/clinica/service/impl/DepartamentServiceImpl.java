package sv.edu.ufg.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import sv.edu.ufg.clinica.model.Departament;
import sv.edu.ufg.clinica.model.Exam;
import sv.edu.ufg.clinica.repo.ICrudRepo;
import sv.edu.ufg.clinica.repo.IDepartamentRepo;
import sv.edu.ufg.clinica.repo.IExamRepo;
import sv.edu.ufg.clinica.service.IDepartamentService;
import sv.edu.ufg.clinica.service.IExamService;

public class DepartamentServiceImpl extends CrudImpl<Departament, Integer> implements IDepartamentService {
    @Autowired
    private IDepartamentRepo repo;
    @Override
    protected ICrudRepo<Departament, Integer> getRepo() {
        return this.repo;
    }
}
