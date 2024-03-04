package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProyectoJPARepository extends JpaRepository<Proyecto, Long> {

/*    public List<Proyecto> findAll() throws RuntimeException;

    public Proyecto save(Proyecto proyecto) throws RuntimeException;

    public Proyecto update(Proyecto proyecto) throws RuntimeException;*/


}
