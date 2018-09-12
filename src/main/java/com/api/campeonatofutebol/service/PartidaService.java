package com.api.campeonatofutebol.service;

import com.api.campeonatofutebol.model.Partida;
import com.api.campeonatofutebol.model.Time;
import com.api.campeonatofutebol.repository.PartidaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;
    private final GenericoService<Partida> genericoService;

    @Autowired
    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
        this.genericoService = new GenericoService<Partida>(partidaRepository);
    }

    @Transactional
    public Partida salva(Partida partida) {
        return this.genericoService.salva(partida);
    }

    @Transactional (readOnly = true)
    public List<Partida> todos() {
        return this.genericoService.buscaTodasAsEntities();
    }


    @Transactional (readOnly = true)
    public Partida buscaPor(Integer id) {
        return this.genericoService.buscaPor(id);
    }

    @Transactional
    public void excluir(Integer id) {
        partidaRepository.deleteById(id);
    }

    @Transactional
    public Partida atualiza(Integer id, Partida partida) {
        Partida partidaManager = this.buscaPor(id);

        BeanUtils.copyProperties(partida, partidaManager, "id");

        this.salva(partida);

        return partidaManager;
    }

}
