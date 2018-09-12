package com.api.campeonatofutebol.service;

import com.api.campeonatofutebol.model.Estadio;
import com.api.campeonatofutebol.model.Jogador;
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
    private final GenericoService<Estadio> genericoService;

    @Autowired
    public EstadioService(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
        this.genericoService = new GenericoService<Estadio>(estadioRepository);
    }

    @Transactional
    public Estadio salva(Estadio estadio) {
        return this.genericoService.salva(estadio);
    }

    @Transactional (readOnly = true)
    public List<Estadio> todos() {
        return this.genericoService.buscaTodasAsEntities();
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
        return this.genericoService.buscaPor(id);
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
