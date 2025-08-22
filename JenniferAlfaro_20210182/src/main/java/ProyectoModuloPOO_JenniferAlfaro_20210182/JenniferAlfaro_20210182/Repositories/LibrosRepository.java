package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Repositories;

import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Entities.LibrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//En este caso repository el cual es una interfaz la cual manda a llamar a los datos del entity teniendo en cuenta el tipo de dato del id
public interface LibrosRepository extends JpaRepository<LibrosEntity, Long> { }
