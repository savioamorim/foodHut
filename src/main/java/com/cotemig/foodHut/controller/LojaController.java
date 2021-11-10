package com.cotemig.foodHut.controller;

import com.cotemig.foodHut.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @RequestMapping(value = "/lojas", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("lojaIndex");
        mv.addObject("lojas", lojaService.getAllLoja());
        return mv;
    }
}
