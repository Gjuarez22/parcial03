package sv.edu.ufg.clinica.service;

import java.util.List;

public interface ICrudService <T,ID>{
    T save(T t);
    T update(T t);
    T findOneById(ID id);
    List<T> findAll();
    void delete(T t);
}
