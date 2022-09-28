package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder                                        //(lombok) genera el constructor
@Data                                           //(lombok) genera setters y getters
public class TecnicoResponse {                  //La información que me devuelve el backend

    //TODO: Revisar si aqui tambien recibo informacion del proyecto (creo que si)

    private String primerNombre;

    private String primerApellido;

    private Integer celular;

    private String ciudad;

    private String barrio;

    private String email;

    private String especialidad;

    private Integer experiencia;

    private Boolean esTecnico;
}
