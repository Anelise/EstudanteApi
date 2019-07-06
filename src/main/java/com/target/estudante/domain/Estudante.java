package com.target.estudante.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estudante {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long matricula;

    private int idade;
    private Long turma;
    private String nome;

    @ManyToMany(targetEntity = Materia.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Materia> materias;

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Estudante() {
    }

    public Estudante(Long matricula, int idade, Long turma, String nome) {
        this.matricula = matricula;
        this.idade = idade;
        this.turma = turma;
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Long getTurma() {
        return turma;
    }

    public void setTurma(Long turma) {
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
