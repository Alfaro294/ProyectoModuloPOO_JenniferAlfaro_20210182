package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
//Getter y Setter
@Getter @Setter @ToString @EqualsAndHashCode
public class LibrosDTO {
//Datos segun la base
    private Long id;
// Para casos not null se utiliza not blank
    @NotBlank(message = "El titulo del libro debe ser obligatorio")
        private String titulo;
    @NotBlank(message = "ISBN Obligatorio")
        private String isbn;
        private Date año_publicacion;
        private String genero;
        //Se muestra la columna que contiene la llave foranea
        private Long autor_id;
}
