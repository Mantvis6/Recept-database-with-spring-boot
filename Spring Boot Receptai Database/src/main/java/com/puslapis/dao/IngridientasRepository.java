package com.puslapis.dao;

import com.puslapis.dao.entities.Ingridientas;
import com.puslapis.dao.entities.Receptas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngridientasRepository extends CrudRepository<Ingridientas, Integer> {

    public List<Ingridientas> findAll();

    public Ingridientas findByPavadinimas(String pavadinimas);

    public List<Ingridientas> findByPavadinimasContaining(String pavadinimas);
}
