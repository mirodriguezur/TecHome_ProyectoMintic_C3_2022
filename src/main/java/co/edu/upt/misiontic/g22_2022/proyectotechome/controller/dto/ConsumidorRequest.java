package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder                                        //(lombok) genera el constructor
@Data                                           //(lombok) genera setters y getters
public class ConsumidorRequest {               //La información con la que voy a crear un consumidor.
    private Integer cedula;

    private String primerNombre;
               
    private String segundoNombre;

    private String primerApellido;
             
    private String segundoApellido;

    private Integer celular;

    private String ciudad;

    private String direccion;

    private String barrio;

    private String email;

    private String password;

    private Boolean esTecnico;
}
