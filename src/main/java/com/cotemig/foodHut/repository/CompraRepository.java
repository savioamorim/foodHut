package com.cotemig.foodHut.repository;

import com.cotemig.foodHut.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("compraRepository")
public interface CompraRepository extends JpaRepository<Produto, Long> {

    @Query(value = "SELECT P.* FROM VENDA AS V JOIN PRODUTO AS P ON V.PRODUTO_ID = P.ID WHERE CLIENTE_ID = ?1", nativeQuery = true)
    List<Produto> getAllProdutoByClienteId(Long id);
}
