package com.cotemig.foodHut.Repository;

import com.cotemig.foodHut.model.ClienteProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clienteProdutoRepository")
public interface ClienteProdutoRepository extends JpaRepository<ClienteProduto, Long> {

    @Query(value="SELECT * FROM VENDA WHERE FK_CLIENTE = ?1", nativeQuery = true)
    List<ClienteProduto> getAllProdutoByClienteId(Long id);
}
