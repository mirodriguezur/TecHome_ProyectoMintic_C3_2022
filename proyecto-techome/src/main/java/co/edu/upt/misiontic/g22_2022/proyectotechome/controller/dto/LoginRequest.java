package co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private Boolean esTecnico;
}
