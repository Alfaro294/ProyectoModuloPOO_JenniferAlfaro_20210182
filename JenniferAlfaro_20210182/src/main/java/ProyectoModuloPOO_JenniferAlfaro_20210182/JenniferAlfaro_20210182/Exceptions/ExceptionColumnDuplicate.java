package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Exceptions;

import lombok.Getter;

public class ExceptionColumnDuplicate extends RuntimeException {
    @Getter
    //En caso de comlumna duplicada muestra esta excepción
    private String columnDuplicate;
    public ExceptionColumnDuplicate(String message) {
        super(message);
    }
public ExceptionColumnDuplicate(String message, String columnDuplicate){
        super(message);
        this.columnDuplicate = columnDuplicate;
}
}
