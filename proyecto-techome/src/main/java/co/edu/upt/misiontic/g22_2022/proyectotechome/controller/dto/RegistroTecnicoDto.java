package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.Data;

@Data
public class RegistroTecnicoDto {
    private String primerNombre;                    
    private String segundoNombre;
    private String primerApellido;               
    private String segundoApellido;
    private Integer cedulaTecnico;
    private Integer celularTecnico;
    private String razonSocial;
    private String ciudadTecnico;
    private String direccionTecnico;
    private String barrioTecnico;
    private String especialidad;
    private Integer experiencia;
    private String emailTecnico;
    private String password;
}
