package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182.Models.ApiResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiResponse <T> {
    private boolean Success;
    private String message;
    private T data;

    //Constructores
    public ApiResponse (boolean success, String message, T data){
        this.Success = success;
        this.message = message;
        this.data = data;
    }
    //Metodos para respuestas comunes
    public static <T> ApiResponse<T>Success(T data){return new ApiResponse<>(true, "Operacion exitosa", data);
    }
}
