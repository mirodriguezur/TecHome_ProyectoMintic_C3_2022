package co.edu.upt.misiontic.g22_2022.proyectotechome.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.LoginRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.SecurityService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/login") // Le indico el path al cual le vamos hacer request.
public class LoginRestController {

    // Operaciones que puedo hacer con controladores tipo Rest.
    // POST -> Insertar (C) (hace referencia a crear)
    // GET -> Consultar / Listar (R) (hace referencia a leer)
    // PUT -> Actualizar (U)
    // PATCH -> Actualizar Campo
    // DELETE -> Borrar (D)

    private final SecurityService securityService; // Tiene una dependencia con el servicio.

    @PostMapping // El metodo que responde cuando le hacen un Post al restController.
    public ResponseEntity<?> login(@RequestBody LoginRequest user) { // @RequestBody en por donde recibo la informacion.
                                                                     // (En el cuerpo de la petición.
        if (user.getEsTecnico()) {
            try {
                var response = securityService.validarTecnico(user.getEmail(), user.getPassword());
                return ResponseEntity.ok(response);
            } catch (RuntimeException ex) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ex.getMessage());
            }
        } else {
            try {
                var response = securityService.validarConsumidor(user.getEmail(), user.getPassword());
                return ResponseEntity.ok(response);
            } catch (RuntimeException ex) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ex.getMessage());
            }
        }
    }
}
