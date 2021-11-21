package com.cotemig.foodHut.restController;

import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.model.ClienteProduto;
import com.cotemig.foodHut.model.Produto;
import com.cotemig.foodHut.service.ClienteProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteProdutoRestController {

    @Autowired
    private ClienteProdutoService clienteProdutoService;

    @RequestMapping(value = "/rest/clienteproduto", method = RequestMethod.POST)
    public void post(Cliente cliente, Produto produto, HttpServletResponse httpResponse) throws IOException {
        ClienteProduto clienteProduto = new ClienteProduto();
        clienteProduto.setCliente(cliente);
        clienteProduto.setProduto(produto);
        httpResponse.sendRedirect("/form");
    }

    @RequestMapping(value = "/rest/clienteproduto", method = RequestMethod.GET)
    public List<ClienteProduto> getAllClienteProduto() {
        return clienteProdutoService.getAllClienteProduto();
    }

    @RequestMapping(value = "/rest/clienteproduto/{id}", method = RequestMethod.GET)
    public Optional<ClienteProduto> getProdutoById(@PathVariable("id") Long id) {
        return clienteProdutoService.getClienteProdutoById(id);
    }

    @RequestMapping(value = "/rest/clienteproduto/", method = RequestMethod.DELETE)
    public void deleteAllProdutos() {
        clienteProdutoService.deleteAllClienteProduto();
    }
}
