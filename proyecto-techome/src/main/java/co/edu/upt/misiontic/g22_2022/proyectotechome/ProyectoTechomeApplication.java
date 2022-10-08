package co.edu.upt.misiontic.g22_2022.proyectotechome;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Consumidor;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Proyecto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.entity.Tecnico;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.repository.ConsumidorRepository;
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
		private final ConsumidorRepository consumidorRepository;

		@Override
		public void run(String... args) throws Exception {
			//Descomentar métodos para probar funcionalidad del backend.
			loadTecnico();
			loadConsumidor();

		}

		private void loadTecnico() {
			//List<Proyecto> proyecto = new ArrayList<Proyecto>();
			tecnicoRepository.save(new Tecnico(1014999999, "Pepito", "Alfonso",
					"Gomez","Ramirez",305111111,"Electricos y Compañia","Bogota","Calle 70 No. 00 - 00", 
					"Estrada", "Electricidad", 5,"any@gmail.com", "123456",  true, true));
		}

		private void  loadConsumidor() {
			List<Proyecto> proyecto = new ArrayList<Proyecto>();
			consumidorRepository.save(new Consumidor(1018999000, "Carlos", "Lorenzo", "Rodriguez", "Jimenez", 
					304123940, "Bogota", "Calle 70 No. 00 - 10", "Las ferias", "anotheremail@gmail.com", 
					"54321", true, false, proyecto));
		}
	}
}
