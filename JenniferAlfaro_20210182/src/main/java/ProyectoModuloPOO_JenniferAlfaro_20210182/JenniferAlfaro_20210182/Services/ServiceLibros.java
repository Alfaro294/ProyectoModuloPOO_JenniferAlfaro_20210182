package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Services;

import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Entities.LibrosEntity;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Exceptions.ExceptionLibros;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Models.DTO.LibrosDTO;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Repositories.LibrosRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
public class ServiceLibros {
    @Autowired
    private LibrosRepository repo;

    public List<LibrosDTO>getAllBooks(){
        List<LibrosEntity> libros = repo.findAll();
        return libros.stream()
                .map(this::converirAllLibrosDTO)
                .collect(Collectors.toList());
    }
    public LibrosDTO insertBooks(@Valid LibrosDTO json){
        if (json == null){
            throw new IllegalArgumentException("La información no puede ser nula");
        }
        try{
            LibrosEntity objData = convertirAEntity(json);
            LibrosEntity libroGuardado = repo.save(objData);
            return converirAllLibrosDTO (libroGuardado);
        } catch (Exception e){
            log.error("Error al registrar" + e.getMessage());
            throw new ExceptionLibros("El libro no pudo ser registrado");
        }
    }
    public LibrosDTO update(long id, @Valid LibrosDTO json){
        LibrosEntity librosExistente = repo.findById(id).orElseThrow(() -> new ExceptionLibros("Libro no encontrado"));
        //Actualización de campos
        librosExistente.setTitulo(json.getTitulo());
        librosExistente.setIsbn(json.getIsbn());
        librosExistente.setAño_publicacion(json.getAño_publicacion());
        librosExistente.setAutor_id(json.getAutor_id());

        //ACtualización del registro
        LibrosEntity libroActualizado = repo.save(librosExistente);

        //Convertir a DTO
        return converirAllLibrosDTO(libroActualizado);
    }

    public boolean delete (long id){
        LibrosEntity existencia = repo.findById(id).orElse(null);

        if (existencia != null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    private LibrosDTO converirAllLibrosDTO(LibrosEntity objEntity){
        LibrosDTO dtoL = new LibrosDTO();
        dtoL.setId(objEntity.getId());
        dtoL.setTitulo(objEntity.getTitulo());
        dtoL.setIsbn(objEntity.getIsbn());
        dtoL.setAño_publicacion(objEntity.getAño_publicacion());
        dtoL.setGenero(objEntity.getGenero());
        dtoL.setAutor_id(objEntity.getAutor_id());

        return dtoL;
    }

    private LibrosEntity convertirAEntity (@Valid LibrosDTO json){
        LibrosEntity entity = new LibrosEntity();
        entity.setTitulo(json.getTitulo());
        entity.setIsbn(json.getIsbn());
        entity.setAño_publicacion(json.getAño_publicacion());
        entity.setGenero(json.getGenero());
        entity.setAutor_id(json.getAutor_id());

        return entity;
    }
}
