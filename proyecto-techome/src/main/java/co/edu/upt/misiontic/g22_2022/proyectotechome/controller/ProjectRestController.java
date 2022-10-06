package co.edu.upt.misiontic.g22_2022.proyectotechome.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ProyectoRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.ProjectService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/project") // Le indico el path al cual le vamos hacer request.
public class ProjectRestController {
    
    private final ProjectService projectService;

    @PostMapping // El metodo que responde cuando le hacen un Post al restController.
    public ResponseEntity<?> crearProyecto(@RequestBody ProyectoRequest proyecto) {
        try {
            var response = projectService.crearProyecto(proyecto);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

}
