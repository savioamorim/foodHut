package com.cotemig.foodHut.service;

import com.cotemig.foodHut.model.Produto;
import com.cotemig.foodHut.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("compraService")
public class CompraServiceImpl implements CompraService{

    @Autowired
    CompraRepository compraRepository;

    @Override
    public List<Produto> getProdutoByClienteId(Long id) {
        return compraRepository.getAllProdutoByClienteId(id);
    }
}
