package co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity                                                 //Esta  clase va a  mapear  una tabla de la base de datos
@Table(name = "proyecto")                               //Le indico como se llama la tabla en la base de datos
@Data                                                   //(lombok) Genera getters y setters automáticamente
@AllArgsConstructor                                     // para que sea capaz de traer los datos de la base de datos, y crear un objeto en JAVA... 
@NoArgsConstructor                                      //...necesito un constructor vacio, y que todos los atributos tengan getters y setters. 
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;
    
    @Column(name = "nombre_proyecto", nullable = false)
    private String nombreProyecto;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer presupuesto;

    @Column(name = "tiempo_entrega", nullable = false)
    private Integer tiempoEntrega;

    @ManyToOne                                          //Se mapea el tipo de relacion entre la tabla proyecto y consumidor
    @JoinColumn(name = "cedula_consumidor")
    private Consumidor consumidor;

    //@ManyToOne                                          //Se mapea el tipo de relacion entre la tabla proyecto y tecnico.
    //@JoinColumn(name = "cedula_tecnico")
    //private Tecnico tecnico;
}
