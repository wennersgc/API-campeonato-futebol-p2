package com.api.campeonatofutebol.service;

import com.api.campeonatofutebol.model.Partida;
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

    @Autowired
    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    @Transactional
    public Partida salva(Partida partida) {
        return partidaRepository.save(partida);
    }

    @Transactional (readOnly = true)
    public List<Partida> todos() {
        return partidaRepository.findAll();
    }


    @Transactional (readOnly = true)
    public Partida buscaPor(Integer id) {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
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
