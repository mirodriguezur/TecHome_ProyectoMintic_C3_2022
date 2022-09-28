package co.edu.upt.misiontic.g22_2022.proyectotechome;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Tecnico;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository.TecnicoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@SpringBootApplication
public class ProyectoTechomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoTechomeApplication.class, args);
	}
	@Component
	@Data
	@AllArgsConstructor
	public static class DataLoader implements CommandLineRunner {

		private final TecnicoRepository tecnicoRepository;

		@Override
		public void run(String... args) throws Exception {
			//Descomentar métodos para probar funcionalidad del backend.
			//loadUsers();

		}

		private void loadUsers() {
			tecnicoRepository.save(new Tecnico(1014999999, "Pepito", "Alfonso",
					"Gomez","Ramirez",305111111,"Electricos y Compañia","Bogota","Calle 70 No. 00 - 00", 
					"Estrada", "Electricista", 5,"any@gmail.com", "123456",  true, true));
		}


	}
}
