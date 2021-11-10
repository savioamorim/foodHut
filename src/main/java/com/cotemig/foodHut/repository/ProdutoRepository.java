package com.cotemig.foodHut.repository;

import com.cotemig.foodHut.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("produtoRepository")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}