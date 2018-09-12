package com.api.campeonatofutebol.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity (name = "campeonato")
public class Campeonato {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size (min = 10, max = 45)
    private String nome;

    @NotNull
    @JsonIgnore
    @JsonFormat (pattern = "yyyy")
    @Column (name = "ano_campeonato")
    private LocalDate anoDoCampeonato;

    @NotNull
    private Boolean ativo;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable( name = "campeonato_times",
            joinColumns = {@JoinColumn (name = "id_campeonato")},
            inverseJoinColumns = {@JoinColumn (name = "id_time")} )
//    @JsonManagedReference (value = "campeonato")
    private List<Time> times = new ArrayList<>();

    @OneToMany (mappedBy = "campeonato")
    @JsonManagedReference (value = "campeonato_partidas")
    private List<Partida> partidas = new ArrayList<>();

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

    public LocalDate getAnoDoCampeonato() {
        return anoDoCampeonato;
    }

    public void setAnoDoCampeonato(LocalDate anoDoCampeonato) {
        this.anoDoCampeonato = anoDoCampeonato;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campeonato that = (Campeonato) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
