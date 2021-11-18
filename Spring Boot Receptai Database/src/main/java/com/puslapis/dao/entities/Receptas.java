package com.puslapis.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "recep")
public class Receptas {
    private String pavadinimas;
    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JsonIgnore
    @JsonManagedReference
    @JoinTable(
            name = "receptu_ingridientai",
            joinColumns = @JoinColumn (name = "recepto_id"),
            inverseJoinColumns = @JoinColumn(name = "ingridiento_id"))
    private List<Ingridientas> receptoIngridientai;
    private String nurodymai;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private double kaina;
    private int ivertinimas;

    public Receptas(){}

    public Receptas(String pavadinimas, List<Ingridientas> receptoIngridientai, String nurodymai, double kaina, int ivertinimas) {
        this.pavadinimas = pavadinimas;
        this.receptoIngridientai = receptoIngridientai;
        this.nurodymai = nurodymai;
        this.kaina = kaina;
        this.ivertinimas = ivertinimas;
    }

    @Override
    public String toString() {
        return "Receptas{" +
                "pavadinimas='" + pavadinimas + '\'' +
                ", receptoIngridientai=" + receptoIngridientai +
                ", nurodymai='" + nurodymai + '\'' +
                ", id=" + id +
                ", kaina=" + kaina +
                ", ivertinimas=" + ivertinimas +
                '}';
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public List<Ingridientas> getReceptoIngridientai() {
        return receptoIngridientai;
    }

    public void setReceptoIngridientai(List<Ingridientas> receptoIngridientai) {
        this.receptoIngridientai = receptoIngridientai;
    }

    public String getNurodymai() {
        return nurodymai;
    }

    public void setNurodymai(String nurodymai) {
        this.nurodymai = nurodymai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getKaina() {return kaina;}

    public void setKaina(double kaina) {this.kaina = kaina;}

    public int getIvertinimas() {return ivertinimas;}

    public void setIvertinimas(int ivertinimas) {this.ivertinimas = ivertinimas;}

    public static Comparator<Receptas> pagalKaina = new Comparator<Receptas>() {
        @Override
        public int compare(Receptas o1, Receptas o2) {
            return Double.compare(o1.getKaina(), o2.getKaina());
        }
    };
}