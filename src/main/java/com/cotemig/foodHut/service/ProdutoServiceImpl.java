package com.cotemig.foodHut.service;

import com.cotemig.foodHut.repository.ProdutoRepository;
import com.cotemig.foodHut.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Produto insertProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deleteAllProduto() {
        produtoRepository.deleteAll();
    }

    @Override
    public void deleteProdutoById(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public void updateProdutoById(Long id, Produto produto) {
        Optional<Produto> optionalProduto = getProdutoById(id);
        optionalProduto.get().setNome(produto.getNome());
        optionalProduto.get().setCategoria(produto.getCategoria());
        optionalProduto.get().setValor(produto.getValor());
        optionalProduto.get().setLoja(produto.getLoja());
        produtoRepository.save(produto);
    }

    @Override
    public void updateProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public Optional<Produto> getProdutoById(Long id) {
        return  produtoRepository.findById(id);
    }

    @Override
    public List<Produto> getAllProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> getProdutoByLojaId(Long id) {
        return produtoRepository.getAllProdutoByLojaId(id);
    }
}
