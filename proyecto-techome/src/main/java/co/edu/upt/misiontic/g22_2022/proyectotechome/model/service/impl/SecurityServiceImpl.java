package co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.impl;

import org.springframework.stereotype.Service;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ConsumidorResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.TecnicoResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository.ConsumidorRepository;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository.TecnicoRepository;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.SecurityService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {               //Los services tienen dependencias con los repositorys.

    private final TecnicoRepository tecnicoRepository;                      
    private final ConsumidorRepository consumidorRepository;

    @Override
    public ConsumidorResponse validarConsumidor(String correo, String password) {
        var consumidorOp = consumidorRepository.findByEmailAndPasswordAndActivoIsTrue(correo, password);
        if (consumidorOp.isEmpty()) {
            throw new RuntimeException("Credenciales inválidas");
        }

        var consumidor = consumidorOp.get();                            //Si obtengo un consimidor de la base de datos, entonces...
        return ConsumidorResponse.builder()                             //Devuelvo un objteo ConsumidorResponse con los estos datos.
                .primerNombre(consumidor.getPrimerNombre())
                .primerApellido(consumidor.getPrimerApellido())
                .celular(consumidor.getCelular())
                .ciudad(consumidor.getCiudad())
                .barrio(consumidor.getBarrio())
                .email(consumidor.getEmail())
                .esTecnico(consumidor.getEsTecnico())
                .build();                                               //Para terminar de  construir el objeto.
    }

    @Override
    public TecnicoResponse validarTecnico(String correo, String password) {
        var tecnicoOp =  tecnicoRepository.findByEmailAndPasswordAndActivoIsTrue(correo, password);
        if (tecnicoOp.isEmpty()) {
            throw new RuntimeException("Credenciales inválidas");
        }

        var tecnico = tecnicoOp.get();                                  //Si obtengo un tecnico de la base de datos, entonces...
        return TecnicoResponse.builder()
                .primerNombre(tecnico.getPrimerNombre())
                .primerApellido(tecnico.getPrimerApellido())
                .celular(tecnico.getCelular())
                .ciudad(tecnico.getCiudad())
                .barrio(tecnico.getBarrio())
                .email(tecnico.getEmail())
                .especialidad(tecnico.getEspecialidad())
                .experiencia(tecnico.getExperiencia())
                .esTecnico(tecnico.getEsTecnico())
                .build();                                               //Para terminar de construir el objeto.
    }

    @Override
    public void activarConsumidor(Integer cedula) {
        var consumidorOp = consumidorRepository.findById(cedula);
        if(consumidorOp.isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }

        var consumidor = consumidorOp.get();
        consumidor.setActivo(true);
        consumidorRepository.save(consumidor);
    }

    @Override
    public void desactivarConsumidor(Integer cedula) {
        var consumidorOp = consumidorRepository.findById(cedula);
        if(consumidorOp.isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }

        var consumidor = consumidorOp.get();
        consumidor.setActivo(false);
        consumidorRepository.save(consumidor);
    }

    @Override
    public void activarTecnico(Integer cedula) {
        var tecnicoOp = tecnicoRepository.findById(cedula);
        if(tecnicoOp.isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }

        var tecnico = tecnicoOp.get();
        tecnico.setActivo(true);
        tecnicoRepository.save(tecnico);
    }

    @Override
    public void desactivarTecnico(Integer cedula) {
        var tecnicoOp = tecnicoRepository.findById(cedula);
        if(tecnicoOp.isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }

        var tecnico = tecnicoOp.get();
        tecnico.setActivo(false);
        tecnicoRepository.save(tecnico);
    }
}
