package com.cotemig.foodHut.controller;

import com.cotemig.foodHut.model.Produto;
import com.cotemig.foodHut.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/produto/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("produtoIndex");
        mv.addObject("produtos", produtoService.getAllProduto());
        return mv;
    }

    @RequestMapping(value = "/produto/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("produtoInsert", "produto", new Produto());
    }

    @RequestMapping(value = "/produto/insert", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("produto") Produto produto,
                               BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        produtoService.insertProduto(produto);
        return "redirect:/produto/index";
    }

    @RequestMapping(value = "/produto/delete", method = RequestMethod.GET)
    public ModelAndView delete(Long id) {

        return new ModelAndView("produtoDelete", "produto", produtoService.getProdutoById(id).get());
    }

    @RequestMapping(value = "/produto/delete", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("produto")Produto produto,
                               BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        produtoService.deleteProdutoById(produto.getId());
        return "redirect:/produto/index";
    }

    @RequestMapping(value = "/produto/update", method = RequestMethod.GET)
    public ModelAndView update(Long id) {

        return new ModelAndView("produtoUpdate", "produto", produtoService.getProdutoById(id).get());
    }

    @RequestMapping(value = "/produto/update", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("produto")Produto produto,
                               BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }

        produtoService.updateProduto(produto);
        return "redirect:/produto/index";
    }

    @RequestMapping(value = "/loja/produto", method = RequestMethod.GET)
    public ModelAndView visualizarProdutos(Long id) {
        ModelAndView mv = new ModelAndView("lojaProduto");
        mv.addObject("produtos", produtoService.getProdutoByLojaId(id));
        return mv;
    }

}
