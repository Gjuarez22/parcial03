package sv.edu.ufg.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.clinica.model.Employe;
import sv.edu.ufg.clinica.model.Exam;
import sv.edu.ufg.clinica.repo.ICrudRepo;
import sv.edu.ufg.clinica.repo.IEmployeRepo;
import sv.edu.ufg.clinica.repo.IExamRepo;
import sv.edu.ufg.clinica.service.IEmployeService;
import sv.edu.ufg.clinica.service.IExamService;

@Service
public class EmployeServiceImpl extends CrudImpl<Employe, Integer> implements IEmployeService {
    @Autowired
    private IEmployeRepo repo;
    @Override
    protected ICrudRepo<Employe, Integer> getRepo() {
        return this.repo;
    }

}
