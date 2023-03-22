package es.jcyl.cursofswd.porhacer;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.repositorios.PorHacerRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PorHacerRepositorioTests {
    @Autowired
    PorHacerRepositorio repositorio;


    @Test
    public void deberia_inyectar_repositorio() {
        assertThat(repositorio).isNotNull();
    }

    @Test
    public void deberiaBuscarPorContenido (){
        List<PorHacer> lista = repositorio.findByTextoContains( "usado");
        assertThat( lista ).hasSize(1);
    }

    @Test
    public void deberiaBuscarNoCompletados() {
        List<PorHacer> lista = repositorio.findByCompletadoFalse();
        assertThat( lista ).hasSize(1);
    }

    @Test
    public void deberiaBuscarCompletados() {
        List<PorHacer> lista = repositorio.buscarCompletados();
        assertThat( lista ).hasSize(3);
    }
}
