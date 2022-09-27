package co.edu.upt.misiontic.g22_2022.proyectotechome.model.service;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ConsumidorRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ConsumidorResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.TecnicoRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.TecnicoResponse;

public interface SecurityService {              //Defino los metodos que voy a usar para el login.

    ConsumidorResponse validarConsumidor(String correo, String password);

    TecnicoResponse validarTecnico(String correo, String password);

    void crearConsumidor(ConsumidorRequest consumidor);

    void crearTecnico(TecnicoRequest tecnico);

    void activarConsumidor(Integer cedula);

    void desactivarConsumidor(Integer cedula);

    void activarTecnico(Integer cedula);

    void desactivarTecnico(Integer cedula);

}
