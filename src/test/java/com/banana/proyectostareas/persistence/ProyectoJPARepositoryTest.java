package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Proyecto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.banana.proyectostareas.persistence"})
@AutoConfigureTestEntityManager
class ProyectoJPARepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(ProyectoJPARepositoryTest.class);

    @Autowired
    private ProyectoJPARepository repo;


   @Test
   void findAll() {
        Proyecto aProyecto = new Proyecto(null, "nuevo proyecto", LocalDate.now() , null);
        repo.save(aProyecto);

        // when
        List<Proyecto> proyectos = repo.findAll();
        logger.info("proyectos:" + proyectos);

        // then
        assertThat(proyectos.size())
                .isGreaterThan(0);

        assertNotNull(proyectos);
    }

    @Test
    void save()  {
        Proyecto nProyecto = new Proyecto(null, "Proyecto rendimiento", LocalDate.now(),null);

        repo.save(nProyecto);

        System.out.println(nProyecto);

        Optional<Proyecto> op = repo.findById(nProyecto.getId());
        Proyecto aProyecto = op.get();
        assertEquals(aProyecto.getId(), nProyecto.getId());
        assertThat(aProyecto.getId()).isGreaterThan(0);
    }

    @Test
    void update() {

        Proyecto nProyecto = new Proyecto(null, "nuevo proyecto", LocalDate.now() , null);
        repo.save(nProyecto);
        System.out.println("nProyecto +++: " + nProyecto);
        Optional<Proyecto> op = repo.findById(nProyecto.getId());
        Proyecto prUpd = op.get();

        Proyecto newPr = new Proyecto(prUpd.getId(), "Rendimiento Update",LocalDate.now(), null );


        Proyecto prCambiado = repo.save(newPr);

        System.out.println("prCambiado +++: " + prCambiado);
        assertNotNull(newPr);
        assertEquals(newPr.getNombre(), prCambiado.getNombre());
        assertEquals(newPr.getFechaCreacion(), prCambiado.getFechaCreacion());
    }
}