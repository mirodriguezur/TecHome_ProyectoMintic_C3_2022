package co.edu.upt.misiontic.g22_2022.proyectotechome.model.service;

import java.util.List;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.InfoOportunidadRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.InfoOportunidadResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ProyectoRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ProyectoResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.RegistroConsumidorDto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.RegistroTecnicoDto;

public interface ProjectService {
    void crearConsumidor(RegistroConsumidorDto consumidor);

    void crearTecnico(RegistroTecnicoDto tecnico);

    ProyectoResponse crearProyecto(ProyectoRequest proyecto);

    List<InfoOportunidadResponse> consultarProyectos(InfoOportunidadRequest infoOportunidad);
}
