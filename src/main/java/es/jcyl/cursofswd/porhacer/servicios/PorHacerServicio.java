package es.jcyl.cursofswd.porhacer.servicios;

import es.jcyl.cursofswd.porhacer.modelos.PorHacer;

import java.util.List;

public interface PorHacerServicio {

    public List<PorHacer> obtenerTodo();
    public PorHacer obtenerPorId (Long id);
    public PorHacer guardarporHacer (PorHacer ph);
    public void eliminarPorHacer(PorHacer ph);

}