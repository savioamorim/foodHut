package com.cotemig.foodHut.restController;

import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Cliente> getAllCliente() {
        return clienteService.getAllCliente();
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public Optional<Cliente> getClienteById(@PathVariable("id") Long id) {
        return clienteService.getClienteById(id);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.DELETE)
    public void deleteAllCliente() {
        clienteService.deleteAllCliente();
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public void deleteClienteById(@PathVariable("id") Long id) {
        clienteService.deleteClienteById(id);
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
    public void updateCliente(@RequestBody Cliente cliente, @PathVariable("id") Long id) {
        clienteService.updateClienteById(id, cliente);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public Cliente insertCliente(@RequestBody Cliente cliente) {
        return clienteService.insertCliente(cliente);
    }
}
