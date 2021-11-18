package com.cotemig.foodHut.service;

import com.cotemig.foodHut.model.Produto;

import java.util.List;

public interface CompraService {

    List<Produto> getProdutoByClienteId(Long id);

}
