package com.cotemig.foodHut.Repository;

import com.cotemig.foodHut.model.ClienteProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("clienteProdutoRepository")
public interface ClienteProdutoRepository extends JpaRepository<ClienteProduto, Long> {
}
