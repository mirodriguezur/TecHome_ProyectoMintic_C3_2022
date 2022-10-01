package co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.RegistroConsumidorDto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.RegistroTecnicoDto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Consumidor;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Proyecto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Tecnico;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository.ConsumidorRepository;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository.TecnicoRepository;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.ProjectService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final TecnicoRepository tecnicoRepository;                      
    private final ConsumidorRepository consumidorRepository;

    @Override
    public void crearConsumidor(RegistroConsumidorDto consumidor) {
        var consumidorOp = consumidorRepository.findById(consumidor.getCedulaConsumidor());   //Esta funcion (findById) ya la implementa el repository.
        if(consumidorOp.isPresent()){
            throw new RuntimeException("Este número de cédula ya está registrado.");
        }

        List<Proyecto> proyectos = new ArrayList<Proyecto>();                   //Como estoy creando un nuevo consumidor, no tiene proyectos.

        var consumidorDb = new Consumidor();                                       //Creo un nuevo consumidor.
        consumidorDb.setPrimerNombre(consumidor.getPrimerNombre());
        consumidorDb.setSegundoNombre(consumidor.getSegundoNombre());
        consumidorDb.setPrimerApellido(consumidor.getPrimerApellido());
        consumidorDb.setSegundoApellido(consumidor.getSegundoApellido());
        consumidorDb.setCedulaConsumidor(consumidor.getCedulaConsumidor());
        consumidorDb.setCelular(consumidor.getCelularConsumidor());
        consumidorDb.setCiudad(consumidor.getCiudad());
        consumidorDb.setDireccion(consumidor.getDireccionConsumidor());
        consumidorDb.setBarrio(consumidor.getBarrioConsumidor());
        consumidorDb.setEmail(consumidor.getEmailConsumidor());
        consumidorDb.setPassword(consumidor.getPassword());  
        consumidorDb.setActivo(true);
        consumidorDb.setEsTecnico(false);
        consumidorDb.setProyectos(proyectos);

        consumidorRepository.save(consumidorDb);
    }

    @Override
    public void crearTecnico(RegistroTecnicoDto tecnico) {
        var tecnicoOp = tecnicoRepository.findById(tecnico.getCedulaTecnico());
        if(tecnicoOp.isPresent()){
            throw new RuntimeException("Este número de cédula ya está registrado.");
        }

        var tecnicoDb = new Tecnico();
        tecnicoDb.setCedulaTecnico(tecnico.getCedulaTecnico());                                   //Creo un nuevo tecnico.
        tecnicoDb.setPrimerNombre(tecnico.getPrimerNombre());
        tecnicoDb.setSegundoNombre(tecnico.getSegundoNombre());
        tecnicoDb.setPrimerApellido(tecnico.getPrimerApellido());
        tecnicoDb.setSegundoApellido(tecnico.getSegundoApellido());
        tecnicoDb.setCelular(tecnico.getCelularTecnico());
        tecnicoDb.setRazonSocial(tecnico.getRazonSocial());
        tecnicoDb.setCiudad(tecnico.getCiudadTecnico());
        tecnicoDb.setDireccion(tecnico.getDireccionTecnico());
        tecnicoDb.setBarrio(tecnico.getBarrioTecnico());
        tecnicoDb.setEspecialidad(tecnico.getEspecialidad());
        tecnicoDb.setExperiencia(tecnico.getExperiencia());
        tecnicoDb.setEmail(tecnico.getEmailTecnico());
        tecnicoDb.setPassword(tecnico.getPassword());
        tecnicoDb.setActivo(true);
        tecnicoDb.setEsTecnico(true);

        tecnicoRepository.save(tecnicoDb);
    }
    
}
