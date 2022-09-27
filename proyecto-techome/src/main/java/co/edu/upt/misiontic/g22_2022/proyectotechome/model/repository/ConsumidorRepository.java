package co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Consumidor;

public interface ConsumidorRepository extends JpaRepository<Consumidor, Integer> {
    Optional<Consumidor> findByEmailAndPasswordAndActiveIsTrue(String email, String password);
}
