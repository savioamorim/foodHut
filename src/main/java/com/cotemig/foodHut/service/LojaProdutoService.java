package com.cotemig.foodHut.service;

import com.cotemig.foodHut.model.Loja;
import com.cotemig.foodHut.model.LojaProduto;
import com.cotemig.foodHut.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface LojaProdutoService {

    void insertLojaProduto(Loja loja, ArrayList<Produto> produtoList);

    void deleteAllLojaProduto();

    void deleteLojaProdutoById(Long id);

    List<LojaProduto> getLojaProdutoByLojaId(Loja loja);

    List<LojaProduto> getAllLojaProduto();
}
