package com.banana.proyectostareas.service;

import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.Tarea;
import com.banana.proyectostareas.persistence.ProyectoJPARepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.banana.proyectostareas.service"})
@EnableAutoConfiguration
class TareaServiceTest {
     @Autowired
     private ProyectoTareaService servicio;

    @Test
    void testBeans(){
     assertNotNull(servicio);

    }

  /*  @Test
    void crearProyecto(){
        Proyecto aProyecto = new Proyecto(null, "nuevo proyecto", LocalDate.now() , null);
        Proyecto proyecto = servicio.crearProyecto(aProyecto);
        assertNotNull(proyecto);
        assertThat(proyecto.getId(), greaterThan(0L));
        assertEquals(proyecto.getNombre(),"nuevo proyecto");
    }

    @Test
    void  anadeTareaAProyecto() {
        Proyecto aProyecto = new Proyecto(null, "nuevo proyecto", LocalDate.now() , null);
        Proyecto proyecto = servicio.crearProyecto(aProyecto);
        Tarea nTarea = new Tarea(null, "desarrollo", LocalDate.now(), 1, false , proyecto);
        servicio.anadeTareaAProyecto(proyecto.getId(), nTarea);
         assertNotNull(proyecto.getTareas());
    }

    @Test
    void  obtenerProyectos() {
        Proyecto aProyecto = new Proyecto(null, "nuevo proyecto", LocalDate.now() , null);
        Proyecto proyecto = servicio.crearProyecto(aProyecto);
        Proyecto aProyecto2 = new Proyecto(null, "nuevo proyecto2", LocalDate.now() , null);
        Proyecto proyecto2 = servicio.crearProyecto(aProyecto);
        List<Proyecto> listProyectos = servicio.obtenerProyectos();
        assertNotNull(listProyectos);
    }

    @Test
    void  obtenerTareasDelProyecto(Long idProyecto) {
    }

    @Test
    void marcarTareaHecha(Long idTarea) {
    }*/

}