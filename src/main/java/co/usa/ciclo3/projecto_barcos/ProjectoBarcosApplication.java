package co.usa.ciclo3.projecto_barcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages ={"co.usa.ciclo3.projecto_barcos.model"})
@SpringBootApplication
public class ProjectoBarcosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectoBarcosApplication.class, args);
	}

}
