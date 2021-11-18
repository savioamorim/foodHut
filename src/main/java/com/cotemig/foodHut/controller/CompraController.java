package com.cotemig.foodHut.controller;

import com.cotemig.foodHut.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class CompraController {

    @Autowired
    private CompraService compraService;

    @RequestMapping(value = "/cliente/compras", method = RequestMethod.GET)
    public ModelAndView visualizarCompras(Long id) {
        ModelAndView mv = new ModelAndView("compras");
        mv.addObject("produtos", compraService.getProdutoByClienteId(id));
        return mv;
    }
}
