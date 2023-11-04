package sv.edu.ufg.clinica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ICrudRepo<T,ID> extends JpaRepository<T,ID> {
}
