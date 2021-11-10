package com.cotemig.foodHut.service;

import com.cotemig.foodHut.repository.LojaProdutoRepository;
import com.cotemig.foodHut.model.Loja;
import com.cotemig.foodHut.model.LojaProduto;
import com.cotemig.foodHut.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("lojaProdutoService")
public class LojaProdutoServiceImpl implements LojaProdutoService {

    @Autowired
    LojaProdutoRepository lojaProdutoRepository;

    @Override
    public void insertLojaProduto(Loja loja, ArrayList<Produto> produtoList) {
        LojaProduto lojaProduto;
        for(Produto produto : produtoList) {
            lojaProduto = new LojaProduto();
            lojaProduto.setLoja(loja);
            lojaProduto.setProduto(produto);
            lojaProdutoRepository.save(lojaProduto);
        }
    }

    @Override
    public void deleteAllLojaProduto() {
        lojaProdutoRepository.deleteAll();
    }

    @Override
    public void deleteLojaProdutoById(Long id) {
        lojaProdutoRepository.deleteById(id);
    }

    @Override
    public List<LojaProduto> getLojaProdutoByLojaId(Loja loja) {
        ArrayList<LojaProduto> lojaProdutoList = new ArrayList<>();
        lojaProdutoList.addAll(lojaProdutoRepository.getAllProdutoByLojaId(loja.getId()));
        return lojaProdutoList;
    }

    @Override
    public List<LojaProduto> getAllLojaProduto() {
        return lojaProdutoRepository.findAll();
    }
}
