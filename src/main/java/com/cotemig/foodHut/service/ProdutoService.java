package com.cotemig.foodHut.service;

import com.cotemig.foodHut.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto insertProduto(Produto cliente);

    void deleteAllProduto();

    void deleteProdutoById(Long id);

    void updateProdutoById(Long id, Produto produto);

    Optional<Produto> getProdutoById(Long id);

    List<Produto> getAllProduto();
}
