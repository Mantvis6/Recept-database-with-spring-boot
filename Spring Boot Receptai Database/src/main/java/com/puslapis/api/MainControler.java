package com.puslapis.api;

import com.puslapis.dao.entities.Ingridientas;
import com.puslapis.dao.entities.Receptas;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import com.puslapis.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/db_veiksmai")
public class MainControler {

    @Autowired
    MainService mainService;

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public void handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        System.out.println(name + " parameter is missing");
        // Actual exception handling
    }

    @PostMapping("/prideti_recepta1")
    public @ResponseBody String pridetiRecepta1 (@RequestBody Receptas receptas){
        return mainService.pridetiRecepta1(receptas);
    }
    @PostMapping("/prideti_recepta")
    public @ResponseBody String pridetiRecepta (@RequestParam String pavadinimas, @RequestParam String receptoIngridientai, @RequestParam String nurodymai, @RequestParam double kaina, @RequestParam int ivertinimas){
        System.out.println(pavadinimas);
        System.out.println(receptoIngridientai);
        System.out.println(nurodymai);
        System.out.println(kaina);
        return mainService.pridetiRecepta(pavadinimas, receptoIngridientai, nurodymai, kaina, ivertinimas);
    }

    @GetMapping("/gauti_receptus")
    public @ResponseBody List<Receptas> gautiReceptus(){
        return mainService.gautiReceptus();
    }

    @GetMapping("/gauti_receptus_by_name")
    public @ResponseBody Receptas gautiReceptusByName(@RequestParam String pavadinimas){
    return mainService.gautiReceptusByName(pavadinimas);
  //  model.addAttribute("pavadinimas", tempReceptas.getPavadinimas());
  //  model.addAttribute("ingridientai", tempReceptas.getIngridientai());
  //  model.addAttribute("nurodymai", tempReceptas.getNurodymai());
  //  return "rodyti_receptus";
    }

    @GetMapping("/gauti_receptus_by_name_containing")
    public @ResponseBody List<Receptas> gautiReceptusByNameContaining(@RequestParam String pavadinimas){
        return mainService.gautiReceptusByNameContaining(pavadinimas);
    }

    @GetMapping("/gauti_receptus_by_recepto_ingridientai_contain")
    public @ResponseBody List<Receptas> gautiReceptusByReceptoIngridientaiContain(@RequestParam String pavadinimas){
        return mainService.gautiReceptusByReceptoIngridientaiContain(pavadinimas);
    }
    @GetMapping("/rikiuoti_receptus_pagal_kaina")
    public @ResponseBody List<Receptas> rikiuotiReceptusPagalKaina(){
        return mainService.rikiuotiReceptusPagalKaina();
    }

    @GetMapping ("/rikiuoti_pagal_kaina")
    public @ResponseBody List<Receptas> findAllByOrderByKaina(){
        return mainService.findAllByOrderByKaina();
    }

    @GetMapping ("/gauti_ingridientus")
    public @ResponseBody List<Ingridientas> gautiIngridientus(){
        return mainService.gautiIngridientus();
    }

    @GetMapping("/rikiuoti_pagal_ivertinima")
    public  @ResponseBody List<Receptas> findAllByOrderByIvertinimas(){return mainService.findAllByOrderByIvertinimasDesc();}

    @GetMapping("/gauti_pagal1_ingridientus")
    public @ResponseBody
    HashMap<Integer, List<Receptas>> gautiPagal1IngridientuSkaiciu(){ return mainService.gautiPagal1IngridientuSkaiciu();}

}
