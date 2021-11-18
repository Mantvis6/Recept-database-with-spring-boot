package com.puslapis.dao.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ingridientai")
public class Ingridientas {
    private String pavadinimas;
    @ManyToMany(mappedBy = "receptoIngridientai")
    @JsonBackReference
    private List<Receptas> ingridientasReceptuose;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private double kaina;

    public Ingridientas(String pavadinimas, int id) {
        this.pavadinimas = pavadinimas;
        this.id = id;
        this.kaina = kaina;
    }

    public Ingridientas() {
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getKaina() {return kaina;}

    public void setKaina(double kaina) {this.kaina = kaina;}

    @Override
    public String toString() {
        return "Ingridientas{" +
                "pavadinimas='" + pavadinimas + '\'' +
                ", id=" + id +
                ", kaina=" + kaina +
                '}';
    }
}
