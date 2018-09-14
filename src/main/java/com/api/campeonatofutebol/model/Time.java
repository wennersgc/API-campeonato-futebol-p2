package com.api.campeonatofutebol.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity (name = "time")
public class Time {

    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 4, max = 45)
    private String nome;

    @OneToMany (mappedBy = "timeQueJoga", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Jogador> jogadores = new ArrayList<>();

    @NotNull
    private Boolean ativo;

    @OneToOne
    @JoinColumn (name = "id_capitao")
    private Jogador capitao;

    @OneToOne
    @JoinColumn (name = "id_sede")
    @JsonIgnore
    private Estadio sede;

    @NotNull
    @OneToMany (mappedBy = "anfitriao", cascade = CascadeType.ALL)
    @JsonManagedReference (value = "anfitriao")
    private List<Partida> foiAnfitriao;

    @NotNull
    @OneToMany (mappedBy = "visitante", cascade = CascadeType.ALL)
    @JsonManagedReference (value = "visitante")
    private List<Partida> foiVisitante;

    @ManyToMany (mappedBy = "times")
    @JsonBackReference
    private List<Campeonato> campeonatos = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Jogador getCapitao() {
        return capitao;
    }

    public void setCapitao(Jogador capitao) {
        this.capitao = capitao;
    }

    public Estadio getSede() {
        return sede;
    }

    public void setSede(Estadio sede) {
        this.sede = sede;
    }

    public List<Partida> getFoiAnfitriao() {
        return foiAnfitriao;
    }

    public void setFoiAnfitriao(List<Partida> foiAnfitriao) {
        this.foiAnfitriao = foiAnfitriao;
    }

    public List<Partida> getFoiVisitante() {
        return foiVisitante;
    }

    public void setFoiVisitante(List<Partida> foiVisitante) {
        this.foiVisitante = foiVisitante;
    }

    public List<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(List<Campeonato> campeonatos) {
        this.campeonatos = campeonatos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(id, time.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
