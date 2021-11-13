package com.cotemig.foodHut.restController;

import com.cotemig.foodHut.model.Produto;
import com.cotemig.foodHut.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoRestController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/produto", method = RequestMethod.GET)
    public List<Produto> getAllProduto() {
        return produtoService.getAllProduto();
    }

    @RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
    public Optional<Produto> getProdutoById(@PathVariable("id") Long id) {
        return produtoService.getProdutoById(id);
    }

    @RequestMapping(value = "/produto", method = RequestMethod.DELETE)
    public void deleteAllProduto() {
        produtoService.deleteAllProduto();
    }

    @RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
    public void deleteProdutoById(@PathVariable("id") Long id) {
        produtoService.deleteProdutoById(id);
    }

    @RequestMapping(value = "/produto/{id}", method = RequestMethod.PUT)
    public void updateProduto(@RequestBody Produto produto, @PathVariable("id") Long id) {
        produtoService.updateProdutoById(id, produto);
    }

    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    public Produto insertProduto(@RequestBody Produto produto) {
        return produtoService.insertProduto(produto);
    }

    @RequestMapping(value = "/produto/loja/{id}", method = RequestMethod.GET)
    public List<Produto> getAllProdutoByLoja(@PathVariable("id") Long id) {
        return produtoService.getProdutoByLojaId(id);
    }
}
