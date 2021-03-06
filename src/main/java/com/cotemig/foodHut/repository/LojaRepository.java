package com.cotemig.foodHut.repository;

import com.cotemig.foodHut.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("lojaRepository")
public interface LojaRepository extends JpaRepository<Loja, Long> {
}
