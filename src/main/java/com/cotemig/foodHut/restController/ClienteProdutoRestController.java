package com.cotemig.foodHut.restController;

import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.model.ClienteProduto;
import com.cotemig.foodHut.model.Produto;
import com.cotemig.foodHut.service.ClienteProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteProdutoRestController {

    @Autowired
    private ClienteProdutoService clienteProdutoService;


    @RequestMapping(value = "/clienteProduto", method = RequestMethod.POST)
    public void insertClienteProduto(@RequestBody Cliente cliente, @RequestBody Produto produto) {
        ClienteProduto clienteProduto = new ClienteProduto();
        clienteProduto.setCliente(cliente);
        clienteProduto.setProduto(produto);
    }

    @RequestMapping(value = "/clienteProduto", method = RequestMethod.GET)
    public List<ClienteProduto> getAllClienteProduto() {
        return clienteProdutoService.getAllClienteProduto();
    }

    @RequestMapping(value = "/clienteProduto/{id}", method = RequestMethod.GET)
    public List<Produto> getProdutoById(Long id) {
        return clienteProdutoService.getClienteProdutoByClienteId(id);
    }

    @RequestMapping(value = "/clienteProduto", method = RequestMethod.DELETE)
    public void deleteAllProdutos() {
        clienteProdutoService.deleteAllClienteProduto();
    }
}
