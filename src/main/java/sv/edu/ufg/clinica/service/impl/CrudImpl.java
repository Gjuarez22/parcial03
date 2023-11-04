package sv.edu.ufg.clinica.service.impl;

import sv.edu.ufg.clinica.repo.ICrudRepo;
import sv.edu.ufg.clinica.service.ICrudService;

import java.util.List;

public abstract class CrudImpl<T,ID> implements ICrudService<T,ID> {
    protected abstract ICrudRepo<T,ID> getRepo();
    @Override
    public T save(T t) {return getRepo().save(t);}
    @Override
    public T update(T t) {return getRepo().save(t);}
    @Override
    public T findOneById(ID id) {return getRepo().findById(id).orElse(null);}
    @Override
    public List findAll() {return getRepo().findAll();}
    @Override
    public void delete(T t) {getRepo().delete(t);}
}
