package com.cotemig.foodHut.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String especialidade;
    private String telefone;

    @Transient
    @OneToMany(mappedBy="loja")
    private Set<Produto> listProdutos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Produto> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(Set<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }
}
