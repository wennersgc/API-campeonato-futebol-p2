package com.api.campeonatofutebol.repository;

import com.api.campeonatofutebol.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Integer> {

    Estadio findByNome(String nome);

    Optional<List<Estadio>> findByNomeContaining(String nome);
}
