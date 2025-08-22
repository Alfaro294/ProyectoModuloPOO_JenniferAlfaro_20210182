package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Services;

import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Entities.LibrosEntity;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Models.DTO.LibrosDTO;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Repositories.LibrosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public class ServiceLibros {
    @Autowired
    private LibrosRepository repo;

    public List<LibrosDTO>getAllBooks(){
        List<LibrosEntity> libros = repo.findAll();
        return libros.stream()
                .map(this::converirAllLibrosDTO)
                
    }
}
