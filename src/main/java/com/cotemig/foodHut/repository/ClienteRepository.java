package com.cotemig.foodHut.repository;

import com.cotemig.foodHut.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
