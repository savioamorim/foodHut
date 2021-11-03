package com.cotemig.foodHut.service;

import com.cotemig.foodHut.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente insertCliente(Cliente cliente);

    void deleteAllCliente();

    void deleteClienteById(Long id);

    void updateClienteById(Long id, Cliente cliente);

    Optional<Cliente> getClienteById(Long id);

    List<Cliente> getAllCliente();
}
