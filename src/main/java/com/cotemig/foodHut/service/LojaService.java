package com.cotemig.foodHut.service;

import com.cotemig.foodHut.model.Loja;

import java.util.List;
import java.util.Optional;

public interface LojaService {

    Loja insertLoja(Loja loja);

    void deleteAllLoja();

    void deleteLojaById(Long id);

    void updateLojaById(Long id, Loja loja);

    Optional<Loja> getLojaById(Long id);

    List<Loja> getAllLoja();
}
