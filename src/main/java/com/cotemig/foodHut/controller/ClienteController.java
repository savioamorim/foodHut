package com.cotemig.foodHut.controller;

import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("clientes", clienteService.getAllCliente());

        return mv;
    }

    @RequestMapping(value = "/cliente/index", method = RequestMethod.GET)
    public ModelAndView clienteIndex() {
        ModelAndView mv = new ModelAndView("clienteINdex");
        mv.addObject("clientes", clienteService.getAllCliente());

        return mv;
    }

    @RequestMapping(value = "/cliente/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("clienteInsert", "cliente", new Cliente());
    }

    @RequestMapping(value = "/cliente/insert", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("cliente")Cliente cliente,
                               BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        clienteService.insertCliente(cliente);
        return "redirect:/cliente/index";
    }

    @RequestMapping(value = "/cliente/delete", method = RequestMethod.GET)
    public ModelAndView delete(Long id) {

        return new ModelAndView("clienteDelete", "cliente", clienteService.getClienteById(id).get());
    }

    @RequestMapping(value = "/cliente/delete", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("cliente")Cliente cliente,
                               BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        clienteService.deleteClienteById(cliente.getId());
        return "redirect:/cliente/index";
    }

    @RequestMapping(value = "/cliente/update", method = RequestMethod.GET)
    public ModelAndView update(Long id) {

        return new ModelAndView("clienteUpdate", "cliente", clienteService.getClienteById(id).get());
    }

    @RequestMapping(value = "/cliente/update", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("cliente")Cliente cliente,
                               BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }

        clienteService.updateCliente(cliente);
        return "redirect:/cliente/index";
    }
}
