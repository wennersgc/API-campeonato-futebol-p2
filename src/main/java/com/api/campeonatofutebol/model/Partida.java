package com.api.campeonatofutebol.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity (name = "partida")
public class Partida {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_partida")
    private LocalDate dataDaPartida;

    @NotNull
    @ManyToOne
    @JsonBackReference(value = "anfitriao")
    @JoinColumn (name = "id_anfitriao")
    private Time anfitriao;

    @NotNull
    @ManyToOne
    @JsonBackReference(value = "visitante")
    @JoinColumn (name = "id_visitante")
    private Time visitante;

    @DecimalMin(value = "0")
    @Column (name = "gols_anfitriao")
    private int golsDoAnfitriao;

    @DecimalMin(value = "0")
    @Column (name = "gols_visitante")
    private int golsDoVisitante;

    @DecimalMin(value = "0")
    @DecimalMax(value = "3")
    @Column (name = "pontos_anfitriao")
    private int pontosDoAnfitriao;

    @DecimalMin(value = "0")
    @DecimalMax(value = "3")
    @Column (name = "pontos_visitante")
    private int pontosDoVisitante;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_estadio")
    private Estadio estadioDaPartida;

    @ManyToOne
    @JsonBackReference (value = "campeonato_partidas")
    @JoinColumn (name = "id_campeonato")
    private Campeonato campeonato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataDaPartida() {
        return dataDaPartida;
    }

    public void setDataDaPartida(LocalDate dataDaPartida) {
        this.dataDaPartida = dataDaPartida;
    }

    public Time getAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(Time anfitriao) {
        this.anfitriao = anfitriao;
    }

    public Time getVisitante() {
        return visitante;
    }

    public void setVisitante(Time visitante) {
        this.visitante = visitante;
    }

    public int getGolsDoAnfitriao() {
        return golsDoAnfitriao;
    }

    public void setGolsDoAnfitriao(int golsDoAnfitriao) {
        this.golsDoAnfitriao = golsDoAnfitriao;
    }

    public int getGolsDoVisitante() {
        return golsDoVisitante;
    }

    public void setGolsDoVisitante(int golsDoVisitante) {
        this.golsDoVisitante = golsDoVisitante;
    }

    public int getPontosDoAnfitriao() {
        return pontosDoAnfitriao;
    }

    public void setPontosDoAnfitriao(int pontosDoAnfitriao) {
        this.pontosDoAnfitriao = pontosDoAnfitriao;
    }

    public int getPontosDoVisitante() {
        return pontosDoVisitante;
    }

    public void setPontosDoVisitante(int pontosDoVisitante) {
        this.pontosDoVisitante = pontosDoVisitante;
    }

    public Estadio getEstadioDaPartida() {
        return estadioDaPartida;
    }

    public void setEstadioDaPartida(Estadio estadioDaPartida) {
        this.estadioDaPartida = estadioDaPartida;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partida partida = (Partida) o;
        return Objects.equals(id, partida.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
