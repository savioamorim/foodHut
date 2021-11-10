package com.cotemig.foodHut.service;

import com.cotemig.foodHut.repository.ClienteRepository;
import com.cotemig.foodHut.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente insertCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteAllCliente() {
        clienteRepository.deleteAll();
    }

    @Override
    public void deleteClienteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void updateClienteById(Long id, Cliente cliente) {
        Optional<Cliente> optionalCliente = getClienteById(id);
        optionalCliente.get().setNome(cliente.getNome());
        optionalCliente.get().setCpf(cliente.getCpf());
        optionalCliente.get().setCelular(cliente.getCelular());
        clienteRepository.save(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }
}
