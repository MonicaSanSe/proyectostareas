package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.Tarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.banana.proyectostareas.persistence"})
@AutoConfigureTestEntityManager
class TareaJPARepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(TareaJPARepositoryTest.class);

    @Autowired
    private TareaJPARepository repo;

    @Autowired
    private ProyectoJPARepository repoPro;

    @Test
    void findByProject(){

        Proyecto nProyecto = new Proyecto(null, "proyecto con tarea", LocalDate.now() , null);
        repoPro.save(nProyecto);
        System.out.println("nProyecto +++: " + nProyecto);
        Optional<Proyecto> opPro = repoPro.findById(nProyecto.getId());
        Proyecto proyec = opPro.get();
        System.out.println("proyec +++: " + proyec);

        Tarea nTarea = new Tarea(null, "desarrollo", LocalDate.now(), 1, false , proyec);
        repo.save(nTarea);
        System.out.println("nTarea +++: " + nTarea);
        Optional<Tarea> op = repo.findById(nTarea.getId());
        Tarea aTarea = op.get();

        List<Tarea>  tareasEnc = repo.findByProyecto(proyec);
        System.out.println("tareasEnc +++: " + tareasEnc);
        assertNotNull(tareasEnc);
    }


    @Test
    void update()  {
        Tarea nTarea = new Tarea(null, "Proyecto rendimiento", LocalDate.now(), 2, true,null);

        repo.save(nTarea);

        System.out.println(nTarea);

        Optional<Tarea> op = repo.findById(nTarea.getId());
        Tarea aTarea = op.get();

        Tarea newTa = new Tarea(aTarea.getId(), "desarrollo Update",LocalDate.now(),1, false, null );
        Tarea taCambiado = repo.save(newTa);

        System.out.println("taCambiado +++: " + taCambiado);
        assertNotNull(newTa);
        assertEquals(newTa.getDescripcion(), taCambiado.getDescripcion());
        assertEquals(newTa.getFechaLimite(), taCambiado.getFechaLimite());
        assertEquals(newTa.getOrden(), taCambiado.getOrden());
        assertEquals(newTa.isCompletada(), taCambiado.isCompletada());
    }
}