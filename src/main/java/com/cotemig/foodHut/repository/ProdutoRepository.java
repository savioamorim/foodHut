package com.cotemig.foodHut.repository;

import com.cotemig.foodHut.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("produtoRepository")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "SELECT * FROM PRODUTO WHERE LOJA_ID = ?1", nativeQuery = true)
    List<Produto> getAllProdutoByLojaId(Long id);
}
