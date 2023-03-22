package es.jcyl.cursofswd.porhacer.controladores;


import es.jcyl.cursofswd.porhacer.modelos.PorHacer;
import es.jcyl.cursofswd.porhacer.servicios.PorHacerServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.xml.ws.Response;
import java.util.List;

@RestController
public class PorHacerControlador {

    @Autowired
    private PorHacerServicio servicio;

    @GetMapping(path = "/v1/porhacer")
    public ResponseEntity<List<PorHacer>> obtenerTodo(){
        return new ResponseEntity<List<PorHacer>>( servicio.obtenerTodo() , HttpStatus.OK);
    }

    @GetMapping(path = "/v1/porhacer/{id}")
    public ResponseEntity<PorHacer> obtenerPorId(@PathVariable("id") long id) {
        PorHacer porHacer;
        try {
            porHacer = servicio.obtenerPorId(id);
        }
        catch (Exception e) {
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok( porHacer );
    }


    @PostMapping (path = "/v1/porhacer")
    public ResponseEntity<PorHacer> nuevo (@RequestBody PorHacer datos) {
        return new ResponseEntity<PorHacer>(servicio.guardarporHacer(datos), HttpStatus.CREATED);
    }

    @PatchMapping (path = "/v1/porhacer")
    public ResponseEntity<PorHacer>  actualizar (@RequestBody PorHacer datos) {
        return new ResponseEntity<PorHacer>(servicio.guardarporHacer(datos), HttpStatus.OK);
    }

    @DeleteMapping (path = "/v1/porhacer/{id}")
    public ResponseEntity eliminarPorId (@PathVariable("id") long id) {
        PorHacer ph = servicio.obtenerPorId(id);
        servicio.eliminarPorHacer(ph);
        return new ResponseEntity<>("Borrado", HttpStatus.OK);
    }

}
