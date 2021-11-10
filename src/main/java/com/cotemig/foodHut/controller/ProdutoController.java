package com.cotemig.foodHut.controller;

import com.cotemig.foodHut.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("produtoIndex");
        mv.addObject("produtos", produtoService.getAllProduto());
        return mv;
    }
}
