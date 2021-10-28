package com.cotemig.foodHut.model;

import javax.persistence.*;

@Entity
@Table(name = "estoque")
public class LojaProduto {

    private Long id;
    private Loja loja;
    private Produto produto;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "fkLoja", nullable = false)
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
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
