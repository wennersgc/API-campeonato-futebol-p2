package com.api.campeonatofutebol.service;

import com.api.campeonatofutebol.model.Campeonato;
import com.api.campeonatofutebol.repository.CampeonatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepository;

    @Autowired
    public CampeonatoService(CampeonatoRepository campeonatoRepository) {
        this.campeonatoRepository = campeonatoRepository;
    }

    @Transactional
    public Campeonato salva(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    @Transactional (readOnly = true)
    public List<Campeonato> todos() {
        return campeonatoRepository.findAll();
    }


    @Transactional (readOnly = true)
    public Campeonato buscarPor(String nome) {
        return campeonatoRepository.findByNome(nome);
    }

    @Transactional (readOnly = true)
    public Campeonato buscaPor(Integer id) {
        return campeonatoRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Transactional
    public void excluir(Integer id) { campeonatoRepository.deleteById(id);
    }

    @Transactional
    public Campeonato atualiza(Integer id, Campeonato campeonato) {
        Campeonato campeonatoManager = this.buscaPor(id);

        BeanUtils.copyProperties(campeonato, campeonatoManager, "id");

        this.salva(campeonato);

        return campeonatoManager;
    }

    @Transactional
    public void atualizarAtributoAtivo(Integer id, boolean ativo) {
        Campeonato campeonato = this.buscaPor(id);

        campeonato.setAtivo(ativo);

        campeonatoRepository.save(campeonato);
    }
}
