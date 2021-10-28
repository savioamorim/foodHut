package com.cotemig.foodHut.Repository;

import com.cotemig.foodHut.model.LojaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("lojaProdutoRepository")
public interface LojaProdutoRepository extends JpaRepository<LojaProduto, Long> {
}
