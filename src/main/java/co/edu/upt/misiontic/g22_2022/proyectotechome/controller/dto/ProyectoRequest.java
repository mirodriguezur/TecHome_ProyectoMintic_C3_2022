package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.Data;

@Data
public class ProyectoRequest {
    private String tipoProyecto;
    private String nombreProyecto;
    private Integer presupuestoProyecto;
    private Integer tiempoProyecto; 
    private String descripcionProyecto;
    private Integer cedulaConsumidor;
}
