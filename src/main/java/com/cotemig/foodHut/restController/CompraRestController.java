package com.cotemig.foodHut.restController;

import com.cotemig.foodHut.model.Produto;
import com.cotemig.foodHut.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompraRestController {

    @Autowired
    private CompraService compraService;

    @RequestMapping(value = "/compras/{id}", method = RequestMethod.GET)
    public List<Produto> getAllProdutoByCliente(@PathVariable("id") Long id) {
        return compraService.getProdutoByClienteId(id);
    }
}
