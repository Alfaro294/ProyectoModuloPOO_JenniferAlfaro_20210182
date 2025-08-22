package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
//Getter y setter
@Entity @Getter @Setter @ToString @EqualsAndHashCode
//@Table se especifica el nombre de la tabla del cual son los datos
@Table (name = "libros")
public class LibrosEntity {
    @Id
    //Se especifica el nombre de la secuencia el cual en base de datos se realizo para el id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seq_libros")
    @SequenceGenerator(name = "seq_libros", sequenceName = "seq_libros", allocationSize = 1)
    @Column (name = "ID")
    private long id;

    @Column (name = "TITULO")
    private String titulo;
    @Column (name = "ISBN")
    private String isbn;
    @Column (name = "AÑO_PUBLICACION")
    private Date año_publicacion;
    @Column (name = "GENERO")
    private String genero;
    @Column (name = "AUTOR_ID")
    private Long autor_id;
}
