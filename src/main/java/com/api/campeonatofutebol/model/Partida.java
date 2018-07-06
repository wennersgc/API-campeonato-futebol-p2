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

    @ManyToOne
    @JsonManagedReference(value = "anfitriao")
    @JoinColumn (name = "id_anfitriao")
    private Time anfitriao;

    @ManyToOne
    @JsonManagedReference (value = "visitante")
    @JoinColumn (name = "id_visitante")
    private Time visitante;

    @Column (name = "gols_anfitriao")
    private int golsComoAnfitriao;

    @Column (name = "gols_visitante")
    private int golsComoVisitante;

    @DecimalMin(value = "0")
    @DecimalMax(value = "3")
    @Column (name = "pontos_anfitriao")
    private int pontosComoAnfitriao;

    @DecimalMin(value = "0")
    @DecimalMax(value = "3")
    @Column (name = "pontos_visitante")
    private int pontosComoVisitante;

    @OneToOne
    @JoinColumn(name = "id_estadio")
    private Estadio estadioDaPartida;

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

    public int getGolsComoAnfitriao() {
        return golsComoAnfitriao;
    }

    public void setGolsComoAnfitriao(int golsComoAnfitriao) {
        this.golsComoAnfitriao = golsComoAnfitriao;
    }

    public int getGolsComoVisitante() {
        return golsComoVisitante;
    }

    public void setGolsComoVisitante(int golsComoVisitante) {
        this.golsComoVisitante = golsComoVisitante;
    }

    public int getPontosComoAnfitriao() {
        return pontosComoAnfitriao;
    }

    public void setPontosComoAnfitriao(int pontosComoAnfitriao) {
        this.pontosComoAnfitriao = pontosComoAnfitriao;
    }

    public int getPontosComoVisitante() {
        return pontosComoVisitante;
    }

    public void setPontosComoVisitante(int pontosComoVisitante) {
        this.pontosComoVisitante = pontosComoVisitante;
    }

    public Estadio getEstadioDaPartida() {
        return estadioDaPartida;
    }

    public void setEstadioDaPartida(Estadio estadioDaPartida) {
        this.estadioDaPartida = estadioDaPartida;
    }
}
