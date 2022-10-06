package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProyectoResponse {
    private String tipoProyecto;
    private String nombreProyecto;
    private Integer presupuestoProyecto;
    private Integer tiempoProyecto; 
    private String descripcionProyecto;
}
