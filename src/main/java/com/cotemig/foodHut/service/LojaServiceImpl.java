package com.cotemig.foodHut.service;

import com.cotemig.foodHut.Repository.LojaRepository;
import com.cotemig.foodHut.model.Loja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("lojaService")
public class LojaServiceImpl implements LojaService {

    @Autowired
    LojaRepository lojaRepository;

    @Override
    public Loja insertLoja(Loja loja) {
        return lojaRepository.save(loja);
    }

    @Override
    public void deleteAllLoja() {
        lojaRepository.deleteAll();
    }

    @Override
    public void deleteLojaById(Long id) {
        lojaRepository.deleteById(id);
    }

    @Override
    public void updateLojaById(Long id, Loja loja) {
        Optional<Loja> getLoja = getLojaById(id);
        getLoja.get().setNome(loja.getNome());
        getLoja.get().setEspecialidade(loja.getEspecialidade());
        getLoja.get().setTelefone(loja.getTelefone());
        lojaRepository.save(loja);
    }

    @Override
    public Optional<Loja> getLojaById(Long id) {
        return lojaRepository.findById(id);
    }

    @Override
    public List<Loja> getAllLoja() {
        return lojaRepository.findAll();
    }
}
