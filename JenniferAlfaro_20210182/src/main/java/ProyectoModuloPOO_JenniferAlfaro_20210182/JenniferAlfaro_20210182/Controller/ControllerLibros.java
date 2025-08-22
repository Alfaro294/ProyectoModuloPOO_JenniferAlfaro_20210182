package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Controller;

import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Entities.LibrosEntity;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Exceptions.ExceptionColumnDuplicate;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Exceptions.ExceptionLibros;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Models.DTO.LibrosDTO;
import ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Services.ServiceLibros;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController @RequestMapping("/api/libros")
public class ControllerLibros {
    @Autowired
    private ServiceLibros serviceLibros;
//EndPoint Para get
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
    //EndPoint para post (agregar)
    @PostMapping("/newBooks")
    private ResponseEntity<Map<String, Object>>insertBooks(@Valid @RequestBody LibrosDTO json, HttpServletRequest request){
        try {
            LibrosDTO response = serviceLibros.insertBooks(json);
            if (response == null) {
                return ResponseEntity.badRequest().body(Map.of(
                        "Error", "Inserción Incorrecta",
                        "Estatus", "Inserción Incorrecta",
                        "Descripcion", "Verifique valores"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                            "Estado", "Completado",
                            "data", response
                    ));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "Status", "Error",
                            "Message", "Error al registrar",
                            "detail", e.getMessage()
                    ));
        }
        }
        //Endpoint para put (actualizar)
        @PutMapping("/updateBooks/{id}")
    public ResponseEntity<?>update(
            @PathVariable Long id, @Valid @RequestBody LibrosDTO libros, BindingResult bindingResult
        ){
            if (bindingResult.hasErrors()) {
                Map<String,String> errores = new HashMap<>();bindingResult.getFieldErrors().forEach(error -> errores .put(error.getField(), error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(errores);
             }
            try{
                LibrosDTO libroActualizado = serviceLibros.update(id, libros);
                return ResponseEntity.ok(libroActualizado);
            }
            catch (ExceptionLibros e){
                return ResponseEntity.notFound().build();
            }
            catch (ExceptionColumnDuplicate e){
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(Map.of("error", "Datos duplicados", "Campo", e.getColumnDuplicate()));
            }
        }
        //EndPoint para eliminar (delete)
@DeleteMapping("/deleteLibros/{id}")
    public ResponseEntity<Map<String,Object>>delete (@PathVariable Long id){
        try{
            if (!serviceLibros.delete(id)){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .header("X-Mensaje-Error", "Categoria no encontrada")
                        .body(Map.of(
                                "error", "not found",
                                "mensaje", "El libro no ha sido encontrado",
                                "timestamp", Instant.now().toString()
                        ));
            }
            return ResponseEntity.ok().body(Map.of("Status", "Proceso completado",
                    "Mensaje", "Libro eliminado con exito"));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("Status", "Error",
                    "Message", "Error al eliminar el libro", "detail", e.getMessage()));
        }
    }
    }


