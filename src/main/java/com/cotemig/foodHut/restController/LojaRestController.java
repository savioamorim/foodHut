package com.cotemig.foodHut.restController;

import com.cotemig.foodHut.model.Loja;
import com.cotemig.foodHut.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LojaRestController {

    @Autowired
    private LojaService lojaService;

    @RequestMapping(value = "/loja", method = RequestMethod.GET)
    public List<Loja> getAllLoja() {
        return lojaService.getAllLoja();
    }

    @RequestMapping(value = "/loja/{id}", method = RequestMethod.GET)
    public Optional<Loja> getLojaById(@PathVariable("id") Long id) {
        return lojaService.getLojaById(id);
    }

    @RequestMapping(value = "/loja", method = RequestMethod.DELETE)
    public void deleteAllLoja() {
        lojaService.deleteAllLoja();
    }

    @RequestMapping(value = "/loja/{id}", method = RequestMethod.DELETE)
    public void deleteLojaById(@PathVariable("id") Long id) {
        lojaService.deleteLojaById(id);
    }

    @RequestMapping(value = "/loja/{id}", method = RequestMethod.PUT)
    public void updateLoja(@RequestBody Loja loja, @PathVariable("id") Long id) {
        lojaService.updateLojaById(id, loja);
    }

    @RequestMapping(value = "/loja", method = RequestMethod.POST)
    public Loja insertLoja(@RequestBody Loja loja) {
        return lojaService.insertLoja(loja);
    }
}
