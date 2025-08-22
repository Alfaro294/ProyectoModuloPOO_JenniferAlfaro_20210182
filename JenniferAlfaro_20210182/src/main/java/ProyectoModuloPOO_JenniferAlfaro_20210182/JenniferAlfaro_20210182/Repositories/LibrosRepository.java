package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Repositories;

import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Entities.LibrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepository extends JpaRepository<LibrosEntity, Long> { }
