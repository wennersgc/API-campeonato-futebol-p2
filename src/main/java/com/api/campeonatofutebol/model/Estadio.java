package com.api.campeonatofutebol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity (name = "estadio")
public class Estadio {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size (min = 5, max = 45)
    private String nome;

    @NotEmpty
    @Size (min = 10, max = 70)
    private String endereco;

    @OneToOne (mappedBy = "sede")
    @JsonIgnore
    @Transient
    private Time timePropietario;

    private Boolean ativo;

    @OneToOne (mappedBy = "estadioDaPartida")
    @JsonIgnore
    @Transient
    private Partida partida;

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

    public Time getTimePropietario() {
        return timePropietario;
    }

    public void setTimePropietario(Time timePropietario) {
        this.timePropietario = timePropietario;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estadio estadio = (Estadio) o;
        return Objects.equals(id, estadio.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
