package co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity                                                 //Esta  clase va a  mapear  una tabla de la base de datos
@Table(name = "consumidor")                             //Le indico como se llama la tabla en la base de datos
@Data                                                   //(lombok) Genera getters y setters automáticamente
@AllArgsConstructor                                     // para que sea capaz de traer los datos de la base de datos, y crear un objeto en JAVA... 
@NoArgsConstructor                                      //...necesito un constructor vacio, y que todos los atributos tengan getters y setters. 
public class Consumidor {
    @Id
    @Column(name = "cedula_consumidor")
    private Integer cedulaConsumidor;

    @Column(name = "primer_nomber", nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nomber")                    
    private String segundoNombre;

    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido")                 
    private String segundoApellido;

    @Column(nullable = false)
    private Integer celular;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String barrio;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private Boolean esTecnico;

    @OneToMany(mappedBy ="consumidor")              //Se mapea la relacion entre consumidor y proyecto.
    private List<Proyecto> proyecto;
}
