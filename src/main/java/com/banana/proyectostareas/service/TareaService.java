package com.banana.proyectostareas.service;

import com.banana.proyectostareas.exception.ProyectoNotFoundException;
import com.banana.proyectostareas.exception.TareaNotFoundException;
import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.Tarea;
import com.banana.proyectostareas.persistence.ProyectoJPARepository;
import com.banana.proyectostareas.persistence.TareaJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService implements ProyectoTareaService{
    @Autowired
    private ProyectoJPARepository proyectoRepo;

    @Autowired
    private TareaJPARepository tareaRepo;

    @PersistenceContext
    EntityManager em;

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) throws RuntimeException {
        return proyectoRepo.save(proyecto);
    }

    @Override
    public Proyecto anadeTareaAProyecto(Long idProyecto, Tarea tarea) throws ProyectoNotFoundException, RuntimeException {
        Proyecto proyecto = proyectoRepo.findById(idProyecto).orElseThrow(() -> new ProyectoNotFoundException(idProyecto));
        List<Tarea> listTareas = proyecto.getTareas();
        listTareas.add(tarea);
        proyecto.setTareas(listTareas);
        return proyectoRepo.save(proyecto);
    }

    @Override
    public List<Proyecto> obtenerProyectos() {
        List<Proyecto> proyectos = proyectoRepo.findAll();
        if (proyectos != null && proyectos.size() > 0) return proyectos;
        else throw new ProyectoNotFoundException("La lista de proyectos está vacía");
    }

    @Override
    public List<Tarea> obtenerTareasDelProyecto(Long idProyecto){
        Proyecto proyecto = proyectoRepo.findById(idProyecto).orElseThrow(() -> new ProyectoNotFoundException(idProyecto));
        List<Tarea> tareas = tareaRepo.findByProyecto(proyecto);
        if (tareas != null && tareas.size() > 0) return tareas;
        else throw new TareaNotFoundException("La lista de tareas del proyecto está vacía");
    }

    @Override
    public Tarea marcarTareaHecha(Long idTarea) {
        Tarea encTarea = tareaRepo.findById(idTarea).orElseThrow(() -> new TareaNotFoundException(idTarea));
        encTarea.setCompletada(true);
        return tareaRepo.save(encTarea);
    }
}
