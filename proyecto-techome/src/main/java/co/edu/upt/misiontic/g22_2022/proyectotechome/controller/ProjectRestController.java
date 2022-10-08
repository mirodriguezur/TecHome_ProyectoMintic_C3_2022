package co.edu.upt.misiontic.g22_2022.proyectotechome.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ProyectoRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.InfoOportunidadRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.InfoOportunidadResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.ProjectService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/project") // Le indico el path al cual le vamos hacer request.
public class ProjectRestController {
    
    private final ProjectService projectService;

    //private final List<InfoOportunidadResponse> oportunidades = Arrays.asList(
    //  new InfoOportunidadResponse("Cambiar Bombillas","Michael", "Cambiar bombillas piso 1", 400000, 2, 304111111, "maru47@hotmail.com"),
    //    new InfoOportunidadResponse("Cambiar contactos","Oscar", "Cambiar contactos caja electrica", 350000, 1, 304000000, "oscar@hotmail.com"),
    //    new InfoOportunidadResponse("Instalacion electrica","Miguel", "Instalar cableado bodega nueva", 2000000, 5, 300999999, "miguel@hotmail.com"),
    //    new InfoOportunidadResponse("Automatizar Garaje","Gloria", "Instalar equipo de automatizacion garaje", 1000000, 2, 30000000, "gloria@hotmail.com"));

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

    @PostMapping("/consultarproyectos")
    public ResponseEntity<?> cargarProyectoPorCategoria(@RequestBody InfoOportunidadRequest oportunidad) {
        try {
            var response = projectService.consultarProyectos(oportunidad);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

}
