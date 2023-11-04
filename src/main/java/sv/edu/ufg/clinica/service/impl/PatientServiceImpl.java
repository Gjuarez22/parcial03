package sv.edu.ufg.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.clinica.model.Patient;
import sv.edu.ufg.clinica.repo.ICrudRepo;
import sv.edu.ufg.clinica.repo.IPatienRepo;
import sv.edu.ufg.clinica.service.IPatientService;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl  extends CrudImpl<Patient,Integer>  implements IPatientService {

    @Autowired
    private IPatienRepo repo;
    @Override
    protected ICrudRepo<Patient, Integer> getRepo() {
        return this.repo;
    }
}
