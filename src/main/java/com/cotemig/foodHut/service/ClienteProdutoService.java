package com.cotemig.foodHut.service;

import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.model.ClienteProduto;
import com.cotemig.foodHut.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ClienteProdutoService {

    void insertClienteProduto(Cliente cliente, ArrayList<Produto> produtoList);

    void deleteAllClienteProduto();

    void deleteClienteProdutoById(Long id);

    List<Produto> getClienteProdutoByClienteId(Long id);

    List<ClienteProduto> getAllClienteProduto();
}
