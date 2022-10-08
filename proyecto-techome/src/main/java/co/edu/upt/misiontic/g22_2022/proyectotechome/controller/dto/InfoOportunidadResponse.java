package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoOportunidadResponse {
    private String nombreProyecto;
    //private String nombreConsumidor;
    private String descripcion;
    private Integer presupuesto;
    private Integer tiempo;
    //private Integer numero;
    //private String email;
}
