package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder                                        //(lombok) genera el constructor
@Data                                           //(lombok) genera setters y getters
public class TecnicoRequest {                   //La información con la que voy a crear un técnico.
    private Integer cedula;

    private String primerNombre;
               
    private String segundoNombre;

    private String primerApellido;
             
    private String segundoApellido;

    private Integer celular;
                 
    private String razonSocial;

    private String ciudad;

    private String direccion;

    private String barrio;
    
    private String especialidad;

    private Integer experiencia;

    private String email;

    private String password;

    private Boolean esTecnico;
}
