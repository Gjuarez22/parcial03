package sv.edu.ufg.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import sv.edu.ufg.clinica.model.Departament;
import sv.edu.ufg.clinica.model.Municipality;
import sv.edu.ufg.clinica.repo.ICrudRepo;
import sv.edu.ufg.clinica.repo.IDepartamentRepo;
import sv.edu.ufg.clinica.repo.IMunicipalityRepo;
import sv.edu.ufg.clinica.service.IDepartamentService;
import sv.edu.ufg.clinica.service.IMunicipalityService;

public class MunicipalityServiceImpl extends CrudImpl<Municipality, Integer> implements IMunicipalityService {
    @Autowired
    private IMunicipalityRepo repo;
    @Override
    protected ICrudRepo<Municipality, Integer> getRepo() {
        return this.repo;
    }
}
