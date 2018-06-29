package com.api.campeonatofutebol.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity (name = "jogador")
public class Jogador implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size (min = 2, max = 45)
    private String nome;

    @NotNull
    @JsonIgnore
    @JsonFormat (pattern = "dd/MM/yyyy")
    @Column (name = "data_nascimento")
    private LocalDate dataDeNascimento;

    @NotNull
    @Size (min = 1, max = 2)
    private String genero;

    @DecimalMin( value = "1.55")
    private double altura;

    @NotNull
    private boolean ativo;

    @Column (name = "instante_criacao")
    public LocalDateTime instanteDaCriacao;

    @JoinColumn (name = "ultima_atualizacao")
    public LocalDateTime ultimaAtualizacao;

    public Jogador() {
    }

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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @PrePersist
    public void prePersiste() {
        this.instanteDaCriacao = LocalDateTime.now();
    }

    public LocalDateTime getInstanteDaCriacao() {
        return instanteDaCriacao;
    }

    public void setInstanteDaCriacao(LocalDateTime instanteDaCriacao) {
        this.instanteDaCriacao = instanteDaCriacao;
    }

    @PreUpdate
    public void preUpdate() {
        this.ultimaAtualizacao = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(id, jogador.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

 }
