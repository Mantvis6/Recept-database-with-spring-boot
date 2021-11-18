package com.puslapis.dao;

import com.puslapis.dao.entities.Ingridientas;
import com.puslapis.dao.entities.Receptas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptasRepository extends CrudRepository<Receptas, Integer> {

    public List<Receptas> findAll();

    public List<Receptas> findByPavadinimas(String pavadinimas);

    public List<Receptas> findByPavadinimasContaining(String pavadinimas);

    public List<Receptas> findByReceptoIngridientaiContaining(Ingridientas ingridientas);

    public List<Receptas> findAllByOrderByKaina();

    public List<Receptas> findAllByOrderByIvertinimasDesc();

}
