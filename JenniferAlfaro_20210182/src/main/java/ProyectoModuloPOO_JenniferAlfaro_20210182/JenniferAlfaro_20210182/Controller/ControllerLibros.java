package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Controller;

import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Entities.LibrosEntity;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Models.DTO.LibrosDTO;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Services.ServiceLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController @RequestMapping("/api/libros")
public class ControllerLibros {
    @Autowired
    private ServiceLibros serviceLibros;

    @GetMapping("/getDataBooks")
    private ResponseEntity <List<LibrosDTO>> getData(){
        List<LibrosDTO> librosDTOS = serviceLibros.getAllBooks();

        if (librosDTOS == null){
            ResponseEntity.badRequest().body(Map.of(
                    "Status", "No hay libros registrados"
            ));
        }
        return ResponseEntity.ok(librosDTOS);
    }
    @PostMapping("/newBooks")
    private ResponseEntity<Map<String, Object>>Insert

}
