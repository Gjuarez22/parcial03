package sv.edu.ufg.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.clinica.model.Exam;
import sv.edu.ufg.clinica.repo.ICrudRepo;
import sv.edu.ufg.clinica.repo.IExamRepo;
import sv.edu.ufg.clinica.service.IExamService;

@Service
public class ExamImpl extends CrudImpl<Exam, Integer> implements IExamService {
    @Autowired
    private IExamRepo repo;
    @Override
    protected ICrudRepo<Exam, Integer> getRepo() {
        return this.repo;
    }
}
