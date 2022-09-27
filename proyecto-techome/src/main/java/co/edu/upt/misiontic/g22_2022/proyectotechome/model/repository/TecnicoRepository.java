package co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    Optional<Tecnico> findByEmailAndPasswordAndActiveIsTrue(String email, String password);
}
