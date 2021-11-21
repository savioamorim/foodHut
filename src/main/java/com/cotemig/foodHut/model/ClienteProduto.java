package com.cotemig.foodHut.model;

import javax.persistence.*;

@Entity
public class ClienteProduto {

    private Long id;
    private Cliente cliente;
    private Produto produto;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "fkCliente", nullable = false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @OneToOne
    @JoinColumn(name = "fkProduto", nullable = false)
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
