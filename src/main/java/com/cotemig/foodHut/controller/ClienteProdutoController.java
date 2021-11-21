package com.cotemig.foodHut.controller;

import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.model.Produto;
import com.cotemig.foodHut.restController.BaseRestController;
import com.cotemig.foodHut.service.ClienteService;
import com.cotemig.foodHut.service.ClienteProdutoService;
import com.cotemig.foodHut.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ClienteProdutoController extends BaseRestController {

    @Autowired
    private ClienteProdutoService clienteProdutoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;


    @RequestMapping(value = "/clienteproduto/insert", method = RequestMethod.GET)
    public ModelAndView insert(Long idCliente) {
        ModelAndView mv = new ModelAndView("insertClienteProduto");
        mv.addObject("cliente", clienteService.getClienteById(idCliente).get());
        mv.addObject("listaProdutos", produtoService.getAllProduto());
        return mv;
    }

    @RequestMapping(value = "/clienteproduto/insert", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("cliente") Cliente cliente, @ModelAttribute("listaProdutos") ArrayList<Produto> listaProduto,
                               BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }

        clienteProdutoService.insertListaProdutoCliente(getClienteEx(), (ArrayList<Produto>) getListaProduto());
        getListaProduto().clear();
        return "redirect:/cliente/index";
    }

    @RequestMapping(value = "/clienteproduto/insertlistaproduto", method = RequestMethod.GET)
    public String insertListaProduto(Long id) {

        Produto produtoEx = new Produto();
        for(Produto prod : getListaProdutoEx()) {
            if(prod.getId().equals(id)) {
                produtoEx = prod;
                break;
            }
        }

        getListaProduto().add(produtoEx);
        return "redirect:/clienteproduto/realizarcompra?id="+getClienteEx().getId();
    }


    @RequestMapping(value = "/clienteproduto/buscarcompras", method = RequestMethod.GET)
    public ModelAndView buscarCompras(Long id) {
        Cliente cliente = clienteService.getClienteById(id).get();
        ModelAndView mv = new ModelAndView("updateClienteProduto");
        mv.addObject("cliente", cliente);
        mv.addObject("listaClienteProdutos", clienteProdutoService.getAllClienteProdutoByCliente(cliente));
        return mv;
    }

    @RequestMapping(value = "/clienteproduto/realizarcompra", method = RequestMethod.GET)
    public ModelAndView realizarCompra(Long id) {

        setClienteEx(clienteService.getClienteById(id).get());

        if(getListaProdutoEx().isEmpty())
            getListaProdutoEx().addAll(produtoService.getAllProduto());

        ModelAndView mv = new ModelAndView("clienteProduto");
        mv.addObject("cliente", getClienteEx());
        mv.addObject("listaProdutos", getListaProdutoEx());

        return mv;
    }
}
