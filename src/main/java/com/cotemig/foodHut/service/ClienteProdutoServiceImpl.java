package com.cotemig.foodHut.service;

import com.cotemig.foodHut.repository.ClienteProdutoRepository;
import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.model.ClienteProduto;
import com.cotemig.foodHut.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<Produto> getClienteProdutoByClienteId(Long id) {
        ArrayList<Produto> produtoArrayList = new ArrayList<>();
        produtoArrayList.addAll(clienteProdutoRepository.getAllProdutoByClienteId(id));
        return produtoArrayList;
    }

    @Override
    public List<ClienteProduto> getAllClienteProduto() {
        return clienteProdutoRepository.findAll();
    }
}
