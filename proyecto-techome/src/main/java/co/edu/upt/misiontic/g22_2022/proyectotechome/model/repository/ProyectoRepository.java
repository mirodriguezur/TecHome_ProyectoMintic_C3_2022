package co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    
}
