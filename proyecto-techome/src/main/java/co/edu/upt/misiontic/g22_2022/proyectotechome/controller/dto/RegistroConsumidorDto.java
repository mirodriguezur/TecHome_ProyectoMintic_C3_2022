package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.Data;

@Data
public class RegistroConsumidorDto {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer cedulaConsumidor;
    private Integer celularConsumidor;
    private String ciudad;
    private String direccionConsumidor;
    private String barrioConsumidor;
    private String emailConsumidor;
    private String password;
}
