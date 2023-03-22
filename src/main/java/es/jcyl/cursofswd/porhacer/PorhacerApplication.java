package es.jcyl.cursofswd.porhacer;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.repositorios.PorHacerRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PorhacerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PorhacerApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(PorHacerRepositorio repo) {
        return (args) -> {
            repo.save(new PorHacer("Eliminar imports no usados", true));
            repo.save(new PorHacer("Limpiar el código", true));
            repo.save(new PorHacer("Construir artefactos", false));
            repo.save(new PorHacer("Desplegar aplicación", true));
            //logger.info("The sample data has been generated");
        };
    }

}
