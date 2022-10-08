package co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    /* 
    @Query(value = "SELECT p.nombre_proyecto AS nombreProyecto, p.descripcion, p.presupuesto, p.tiempo_entrega AS tiempo, c.primer_nomber AS nombreConsumidor, c.celular AS numero, c.email " 
                + "FROM proyecto p "
                + "JOIN consumidor c USING (cedula_consumidor) "
                + "WHERE p.tipo = ? ", nativeQuery = true)
    List<Map<String, Object>> consultaOportunidades(String categoria);
    */



    List<Proyecto> findAllByTipo(String categoria);
}
