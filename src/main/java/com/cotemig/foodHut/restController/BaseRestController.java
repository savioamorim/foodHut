package com.cotemig.foodHut.restController;

import com.cotemig.foodHut.model.Cliente;
import com.cotemig.foodHut.model.ClienteProduto;
import com.cotemig.foodHut.model.Loja;
import com.cotemig.foodHut.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class BaseRestController {
    private List<Cliente> clienteBase;
    private List<Produto> listaProduto;
    private List<Produto> listaProdutoEx;
    private List<Loja> listLoja;
    private List<Loja> listLojaEx;
    private List<ClienteProduto> listaClienteProduto;

    private Cliente clienteEx;
    private Loja lojaEx;

    public BaseRestController() {
        setclienteBase(new ArrayList<Cliente>());
        setListaProduto(new ArrayList<Produto>());
        setListaProdutoEx(new ArrayList<Produto>());
        setListLoja(new ArrayList<Loja>());
        setListLojaEx(new ArrayList<Loja>());
        setClienteEx(new Cliente());
    }

    public List<Loja> getListLoja() {
        return listLoja;
    }

    public void setListLoja(List<Loja> listLoja) {
        this.listLoja = listLoja;
    }

    public List<Loja> getListLojaEx() {
        return listLojaEx;
    }

    public void setListLojaEx(List<Loja> listLojaEx) {
        this.listLojaEx = listLojaEx;
    }

    public List<Cliente> getCliente() {
        return clienteBase;
    }

    public void setclienteBase(List<Cliente> clienteBase) {
        this.clienteBase = clienteBase;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> produto) {
        this.listaProduto = produto;
    }

    public List<ClienteProduto> getListaClienteProduto() {
        return listaClienteProduto;
    }

    public void setListaClienteProduto(List<ClienteProduto> listaClienteProduto) {
        this.listaClienteProduto = listaClienteProduto;
    }

    public List<Produto> getListaProdutoEx() {
        return listaProdutoEx;
    }

    public void setListaProdutoEx(List<Produto> listaProdutoEx) {
        this.listaProdutoEx = listaProdutoEx;
    }

    public Cliente getClienteEx() {
        return clienteEx;
    }

    public void setClienteEx(Cliente clienteEx) {
        this.clienteEx = clienteEx;
    }

    public Loja getLojaEx() {
        return lojaEx;
    }

    public void setLojaEx(Loja lojaEx) {
        this.lojaEx = lojaEx;
    }
}
