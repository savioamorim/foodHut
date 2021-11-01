package com.cotemig.foodHut.Repository;

import com.cotemig.foodHut.model.LojaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("lojaProdutoRepository")
public interface LojaProdutoRepository extends JpaRepository<LojaProduto, Long> {

    @Query(value = "SELECT * FROM ESTOQUE WHERE FK_LOJA = ?1", nativeQuery = true)
    List<LojaProduto> getAllProdutoByLojaId(Long id);
}
