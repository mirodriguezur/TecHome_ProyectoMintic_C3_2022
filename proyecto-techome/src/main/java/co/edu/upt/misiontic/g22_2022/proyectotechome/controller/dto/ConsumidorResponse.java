package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder                                        //(lombok) genera el constructor
@Data                                           //(lombok) genera setters y getters
public class ConsumidorResponse {
    //TODO: Revisar si aqui tambien recibo informacion del consumidor (creo que si)

    private String primerNombre;

    private String primerApellido;

    private Integer cedulaConsumidor;

    private Integer celular;

    private String ciudad;

    private String barrio;

    private String email;

    @Builder.Default
    private Boolean esTecnico = false;
}
