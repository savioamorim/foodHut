package com.cotemig.foodHut.service;

import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.model.ClienteProduto;
import com.cotemig.foodHut.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ClienteProdutoService {

    Optional<ClienteProduto> getClienteProdutoById(Long id);
    List<ClienteProduto> getAllClienteProduto();
    void deleteAllClienteProduto();
    void deleteClienteProdutoById(Long id);
    void insertListaProdutoCliente(Cliente cliente, ArrayList<Produto> listaProduto);
    List<ClienteProduto> getAllClienteProdutoByCliente(Cliente cliente);

}
