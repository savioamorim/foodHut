package com.cotemig.foodHut.controller;

import com.cotemig.foodHut.model.Loja;
import com.cotemig.foodHut.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @RequestMapping(value = "/loja/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("lojaIndex");
        mv.addObject("lojas", lojaService.getAllLoja());
        return mv;
    }

    @RequestMapping(value = "/loja/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("lojaInsert", "loja", new Loja());
    }

    @RequestMapping(value = "/loja/insert", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("loja")Loja loja,
                               BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        lojaService.insertLoja(loja);
        return "redirect:/loja/index";
    }

    @RequestMapping(value = "/loja/delete", method = RequestMethod.GET)
    public ModelAndView delete(Long id) {
        return new ModelAndView("lojaDelete", "loja", lojaService.getLojaById(id).get());
    }

    @RequestMapping(value = "/loja/delete", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("loja")Loja loja,
                               BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        lojaService.deleteLojaById(loja.getId());
        return "redirect:/loja/index";
    }

    @RequestMapping(value = "/loja/update", method = RequestMethod.GET)
    public ModelAndView update(Long id) {

        return new ModelAndView("lojaUpdate", "loja", lojaService.getLojaById(id).get());
    }

    @RequestMapping(value = "/loja/update", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("loja")Loja loja,
                               BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }

        lojaService.updateLoja(loja);
        return "redirect:/loja/index";
    }
}
