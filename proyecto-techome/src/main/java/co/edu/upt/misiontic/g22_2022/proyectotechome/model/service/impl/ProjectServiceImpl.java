package co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.tomcat.jni.ProcErrorCallback;
import org.springframework.stereotype.Service;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.InfoOportunidadRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.InfoOportunidadResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ProyectoRequest;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.ProyectoResponse;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.RegistroConsumidorDto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.RegistroTecnicoDto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Consumidor;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Proyecto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Tecnico;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository.ConsumidorRepository;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository.ProyectoRepository;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository.TecnicoRepository;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.ProjectService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final TecnicoRepository tecnicoRepository;                      
    private final ConsumidorRepository consumidorRepository;
    private final ProyectoRepository proyectoRepository; 

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

    @Override
    public ProyectoResponse crearProyecto(ProyectoRequest proyecto) {
        
        var consumidorOp = consumidorRepository.findById(proyecto.getCedulaConsumidor());  //Para crear un proyecto, tengo que asociarle el usuaio que lo esta creando
        if(consumidorOp.isEmpty()){
            throw new RuntimeException("El consumidor no existe");
        }
        var proyectoDb = new Proyecto();
        proyectoDb.setTipo(proyecto.getTipoProyecto());
        proyectoDb.setNombreProyecto(proyecto.getNombreProyecto());
        proyectoDb.setDescripcion(proyecto.getDescripcionProyecto());
        proyectoDb.setPresupuesto(proyecto.getPresupuestoProyecto());
        proyectoDb.setTiempoEntrega(proyecto.getTiempoProyecto());
        proyectoDb.setConsumidor(consumidorOp.get());   //El .get es para desenvolver el opcional
        proyectoDb = proyectoRepository.save(proyectoDb);

        return getProyectoById(proyectoDb.getIdProyecto());
    }

    public ProyectoResponse getProyectoById(Integer id) {
        var proyectoOp = proyectoRepository.findById(id);
        if (proyectoOp.isEmpty()) {
            throw new RuntimeException("El producto no existe");
        }
        var proyecto = proyectoOp.get();
        return ProyectoResponse.builder()
                .tipoProyecto(proyecto.getTipo())
                .nombreProyecto(proyecto.getNombreProyecto())
                .presupuestoProyecto(proyecto.getPresupuesto())
                .tiempoProyecto(proyecto.getTiempoEntrega())
                .descripcionProyecto(proyecto.getDescripcion())
                .build();
    }
    
    @Override
    public List<InfoOportunidadResponse> consultarProyectos(InfoOportunidadRequest infoOportunidad) {
        var  oportunidades = proyectoRepository.findAllByTipo(infoOportunidad.getCategoria());

        var listadoOportunidades = oportunidades.stream()
                    .map(oport -> InfoOportunidadResponse.builder()
                    .nombreProyecto(oport.getNombreProyecto())
                    .descripcion(oport.getDescripcion())
                    .presupuesto(oport.getPresupuesto())
                    .tiempo(oport.getTiempoEntrega())
                    .build())
                    .collect(Collectors.toList());

        return listadoOportunidades;
    }

    /* Esta funcion es para hacer la consulta completa entre tablas, pero no he podido hacer que funcione.
    @Override
    public List<InfoOportunidadResponse> consultarProyectos(InfoOportunidadRequest infoOportunidad) {
        var oportunidades = proyectoRepository.consultaOportunidades(infoOportunidad.getCategoria());
        
        for(Map<String, Object> map : oportunidades){
            for(Map.Entry<String, Object> entry : map.entrySet()){
                String key = entry.getKey();
                 //Object value = entry.getValue();
            }
        }
        List<InfoOportunidadResponse> listaOportunidades = new ArrayList<InfoOportunidadResponse>();

        if (oportunidades.isEmpty()) {
            throw new RuntimeException("No hay proyectos para su especialidad");
        }
         
        for (Map<String,Object> i: oportunidades) {
            listaOportunidades.add((InfoOportunidadResponse) i.values());
        }
        return oportunidades;
        
    }
    */
    
}
