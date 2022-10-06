package co.edu.upt.misiontic.g22_2022.proyectotechome.model.service;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ProyectoRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ProyectoResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.RegistroConsumidorDto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.RegistroTecnicoDto;

public interface ProjectService {
    void crearConsumidor(RegistroConsumidorDto consumidor);

    void crearTecnico(RegistroTecnicoDto tecnico);

    ProyectoResponse crearProyecto(ProyectoRequest proyecto);
}
