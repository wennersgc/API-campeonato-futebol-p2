package com.api.campeonatofutebol.repository;

import com.api.campeonatofutebol.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer> {

    Campeonato findByNome(String nome);
}
