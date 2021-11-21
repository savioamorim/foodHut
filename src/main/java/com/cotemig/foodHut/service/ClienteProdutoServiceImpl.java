package com.cotemig.foodHut.service;

import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.model.ClienteProduto;
import com.cotemig.foodHut.model.Produto;
import com.cotemig.foodHut.repository.ClienteProdutoRepository;
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
    public Optional<ClienteProduto> getClienteProdutoById(Long id) {
        return clienteProdutoRepository.findById(id);
    }

    @Override
    public List<ClienteProduto> getAllClienteProduto() {
        return clienteProdutoRepository.findAll();
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
    public void insertListaProdutoCliente(Cliente cliente, ArrayList<Produto> listaProduto) {
        ClienteProduto clienteProduto;
        for(Produto prod : listaProduto) {
            clienteProduto = new ClienteProduto();
            clienteProduto.setCliente(cliente);
            clienteProduto.setProduto(prod);
            clienteProdutoRepository.save(clienteProduto);
        }
    }

    @Override
    public List<ClienteProduto> getAllClienteProdutoByCliente(Cliente cliente) {
        ArrayList<ClienteProduto> listaClienteProduto = new ArrayList<>();
        listaClienteProduto.addAll(clienteProdutoRepository.getAllProdutoByClienteId(cliente.getId()));
        return listaClienteProduto;
    }
}
