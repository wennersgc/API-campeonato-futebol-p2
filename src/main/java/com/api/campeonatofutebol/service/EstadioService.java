package com.api.campeonatofutebol.service;

import com.api.campeonatofutebol.model.Estadio;
import com.api.campeonatofutebol.repository.EstadioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadioService {

    private final EstadioRepository estadioRepository;

    @Autowired
    public EstadioService(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    @Transactional
    public Estadio salva(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    @Transactional (readOnly = true)
    public List<Estadio> todos() {
        return estadioRepository.findAll();
    }

    @Transactional (readOnly = true)
    public List<Estadio> listarPor(String nome) {
        return  estadioRepository.findByNomeContaining(nome )
                .orElse(new ArrayList<>() );
    }

    @Transactional (readOnly = true)
    public Estadio buscarPor(String nome) {
        return estadioRepository.findByNome(nome);
    }

    @Transactional (readOnly = true)
    public Estadio buscaPor(Integer id) {
        return estadioRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Transactional
    public void excluir(Integer id) {
        estadioRepository.deleteById(id);
    }

    @Transactional
    public Estadio atualiza(Integer id, Estadio estadio) {
        Estadio estadioManager = this.buscaPor(id);

        BeanUtils.copyProperties(estadio, estadioManager, "id");

        this.salva(estadio);

        return estadioManager;
    }

    @Transactional
    public void atualizarAtributoAtivo(Integer id, boolean ativo) {
        Estadio estadio = this.buscaPor(id);

        estadio.setAtivo(ativo);

        estadioRepository.save(estadio);
    }
}
