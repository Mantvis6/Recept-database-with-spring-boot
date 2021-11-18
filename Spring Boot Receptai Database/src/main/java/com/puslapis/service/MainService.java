package com.puslapis.service;

import com.puslapis.dao.IngridientasRepository;
import com.puslapis.dao.ReceptasRepository;
import com.puslapis.dao.entities.Ingridientas;
import com.puslapis.dao.entities.Receptas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class MainService {
    @Autowired
    ReceptasRepository receptasRepository;
    @Autowired
    IngridientasRepository ingridientasRepository;

    public String pridetiRecepta1(Receptas receptas) {
        receptasRepository.save(receptas);
        return "saved";
    }

    public String pridetiRecepta(String pavadinimas, String ingridientai, String nurodymai, double kaina, int ivertinimas) {
        List<Ingridientas> visiIngridientai = new ArrayList<Ingridientas>();
        String[] S = ingridientai.split(",");
        for (int i = 0; i < S.length; i++) {
            Ingridientas tempIngridientas = ingridientasRepository.findByPavadinimas(S[i]);
            visiIngridientai.add(tempIngridientas);
        }
        Receptas NewReceptas = new Receptas(pavadinimas, visiIngridientai, nurodymai, kaina, ivertinimas);
        receptasRepository.save(NewReceptas);
        return "saved";
    }

    public List<Receptas> gautiReceptus() {

        return receptasRepository.findAll();
    }

    public Receptas gautiReceptusByName(String pavadinimas) {
        List<Receptas> tempReceptai = receptasRepository.findByPavadinimas(pavadinimas);
        Receptas tempReceptas = new Receptas();
        if (tempReceptai.size() > 0) {
            tempReceptas = tempReceptai.get(0);
        }
        return tempReceptas;

    }

    public List<Receptas> gautiReceptusByNameContaining(String pavadinimas) {
        return receptasRepository.findByPavadinimasContaining(pavadinimas);
    }

    public List<Receptas> gautiReceptusByReceptoIngridientaiContain(String pavadinimas) {

        return receptasRepository.findByReceptoIngridientaiContaining(ingridientasRepository.findByPavadinimas(pavadinimas));
    }

    public List<Receptas> rikiuotiReceptusPagalKaina() {
        List<Receptas> surikiuoti = receptasRepository.findAll();

        Collections.sort(surikiuoti, Receptas.pagalKaina);
        return surikiuoti;
    }

    public List<Receptas> findAllByOrderByKaina() {
        return receptasRepository.findAllByOrderByKaina();
    }

    public List<Ingridientas> gautiIngridientus() {
        return ingridientasRepository.findAll();
    }

    public List<Receptas> findAllByOrderByIvertinimasDesc() {
        return receptasRepository.findAllByOrderByIvertinimasDesc();
    }

    public synchronized void addToList(Integer mapKey, Receptas receptas, HashMap<Integer, List<Receptas>> sugrupuotiReceptaiPagalIngridientus){
        List<Receptas> receptoListas = sugrupuotiReceptaiPagalIngridientus.get(mapKey);
        if(receptoListas == null){
            receptoListas = new ArrayList<>();
            receptoListas.add(receptas);
            sugrupuotiReceptaiPagalIngridientus.put(mapKey, receptoListas);
        }
        else{
            if (!receptoListas.contains(receptas)){
                receptoListas.add(receptas);
            }
        }
    }

    public HashMap<Integer, List<Receptas>> gautiPagal1IngridientuSkaiciu() {
 /*       List<Receptas> pagal1Ingridientus = new ArrayList<>();
        for (int i = 0; i < receptasRepository.findAll().size(); i++) {
            if (receptasRepository.findAll().get(i).getReceptoIngridientai().size() == 1) {
                pagal1Ingridientus.add(receptasRepository.findAll().get(i));
                Collections.sort(pagal1Ingridientus, Receptas.pagalKaina);
            }
        }
        Receptas brangiausiasPagal1Ingridientus = new Receptas();
        for (int i=0; i< pagal1Ingridientus.size(); i++) {
            brangiausiasPagal1Ingridientus = pagal1Ingridientus.get(0);
           if (pagal1Ingridientus.get(i).getKaina() > brangiausiasPagal1Ingridientus.getKaina()) {
                brangiausiasPagal1Ingridientus = pagal1Ingridientus.get(i);
            }
        }
        return brangiausiasPagal1Ingridientus;

  */
        HashMap<Integer, List<Receptas>> sugrupuotiReceptaiPagalIngridientus = new HashMap<Integer, List<Receptas>>();

        List<Receptas> visiReceptai = receptasRepository.findAll();
        for(int i = 0; i< visiReceptai.size(); i++){
            addToList(visiReceptai.get(i).getReceptoIngridientai().size(), visiReceptai.get(i), sugrupuotiReceptaiPagalIngridientus);

        }
        return sugrupuotiReceptaiPagalIngridientus;

    }

}
