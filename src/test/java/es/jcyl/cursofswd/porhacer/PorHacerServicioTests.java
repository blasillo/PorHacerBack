package es.jcyl.cursofswd.porhacer;


import java.util.ArrayList;
import java.util.List;
import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.repositorios.PorHacerRepositorio;
import es.jcyl.cursofswd.porhacer.servicios.PorHacerServicioImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
public class PorHacerServicioTests {
    @Mock
    private PorHacerRepositorio repo;

    @InjectMocks
    private PorHacerServicioImpl servicio;


    @Test
    public void probarAccesoATodos(){
        List<PorHacer> toDoList = new ArrayList<PorHacer>();
        toDoList.add(new PorHacer(1,"Muestra 1",true));
        toDoList.add(new PorHacer(2,"Muestra 2",true));
        toDoList.add(new PorHacer(3,"Muestra 3",false));
        when(repo.findAll()).thenReturn(toDoList);

        List<PorHacer> result = servicio.obtenerTodo();
        assertEquals(3, result.size());
    }
}
