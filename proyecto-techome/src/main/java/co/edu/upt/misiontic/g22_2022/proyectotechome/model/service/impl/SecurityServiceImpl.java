package co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.impl;

import org.springframework.stereotype.Service;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ConsumidorRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ConsumidorResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.TecnicoRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.TecnicoResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Consumidor;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Tecnico;
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
    public void crearConsumidor(ConsumidorRequest consumidor) {
        var consumidorOp = consumidorRepository.findById(consumidor.getCedula());   //Esta funcion (findById) ya la implementa el repository.
        if(consumidorOp.isPresent()){
            throw new RuntimeException("Este número de cédula ya está registrado.");
        }

        var consumidorDb = new Consumidor();                                       //Creo un nuevo consumidor.
        consumidorDb.setCedula(consumidor.getCedula());
        consumidorDb.setPrimerNombre(consumidor.getPrimerNombre());
        consumidorDb.setSegundoNombre(consumidor.getSegundoNombre());
        consumidorDb.setPrimerApellido(consumidor.getPrimerApellido());
        consumidorDb.setSegundoApellido(consumidor.getSegundoApellido());
        consumidorDb.setCelular(consumidor.getCelular());
        consumidorDb.setCiudad(consumidor.getCiudad());
        consumidorDb.setDireccion(consumidor.getDireccion());
        consumidorDb.setBarrio(consumidor.getBarrio());
        consumidorDb.setEmail(consumidor.getEmail());
        consumidorDb.setPassword(consumidor.getPassword());
        consumidorDb.setEsTecnico(consumidor.getEsTecnico());        
    }

    @Override
    public void crearTecnico(TecnicoRequest tecnico) {
        var tecnicoOp = tecnicoRepository.findById(tecnico.getCedula());
        if(tecnicoOp.isPresent()){
            throw new RuntimeException("Este número de cédula ya está registrado.");
        }

        var tecnicoDb = new Tecnico();
        tecnicoDb.setCedula(tecnico.getCedula());                                   //Creo un nuevo tecnico.
        tecnicoDb.setPrimerNombre(tecnico.getPrimerNombre());
        tecnicoDb.setSegundoNombre(tecnico.getSegundoNombre());
        tecnicoDb.setPrimerApellido(tecnico.getPrimerApellido());
        tecnicoDb.setSegundoApellido(tecnico.getSegundoApellido());
        tecnicoDb.setCelular(tecnico.getCelular());
        tecnicoDb.setRazonSocial(tecnico.getRazonSocial());
        tecnicoDb.setCiudad(tecnico.getCiudad());
        tecnicoDb.setDireccion(tecnico.getBarrio());
        tecnicoDb.setBarrio(tecnico.getBarrio());
        tecnicoDb.setEspecialidad(tecnico.getEspecialidad());
        tecnicoDb.setExperiencia(tecnico.getExperiencia());
        tecnicoDb.setEmail(tecnico.getEmail());
        tecnicoDb.setPassword(tecnico.getPassword());
        tecnicoDb.setEsTecnico(tecnico.getEsTecnico());
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
