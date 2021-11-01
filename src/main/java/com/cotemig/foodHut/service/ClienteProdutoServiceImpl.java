package com.cotemig.foodHut.service;

import com.cotemig.foodHut.Repository.ClienteProdutoRepository;
import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.model.ClienteProduto;
import com.cotemig.foodHut.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("clienteProdutoService")
public class ClienteProdutoServiceImpl implements ClienteProdutoService {

    @Autowired
    ClienteProdutoRepository clienteProdutoRepository;

    @Override
    public void insertClienteProduto(Cliente cliente, ArrayList<Produto> produtoList) {
        ClienteProduto clienteProdutoCompra;
        for(Produto produtoCompra : produtoList) {
            clienteProdutoCompra = new ClienteProduto();
            clienteProdutoCompra.setCliente(cliente);
            clienteProdutoCompra.setProduto(produtoCompra);
            clienteProdutoRepository.save(clienteProdutoCompra);
        }
    }

    @Override
    public void deleteAllClienteProduto() {
        clienteProdutoRepository.deleteAll();
    }

    @Override
    public void deleteClienteProdutoById(Long id) {
        clienteProdutoRepository.deleteById(id);
    }

    @Override
    public List<ClienteProduto> getClienteProdutoByClienteId(Cliente cliente) {
        ArrayList<ClienteProduto> clienteProdutoList = new ArrayList<>();
        clienteProdutoList.addAll(clienteProdutoRepository.getAllProdutoByClienteId(cliente.getId()));
        return clienteProdutoList;
    }

    @Override
    public List<ClienteProduto> getAllClienteProduto() {
        return clienteProdutoRepository.findAll();
    }
}
