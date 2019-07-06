package com.target.estudante;

import com.target.estudante.domain.Estudante;
import com.target.estudante.domain.Materia;

public class EstudanteDTO {
    private Long matricula;
    private int idade;
    private Long turma;
    private String nome;

    public EstudanteDTO() {
    }

    public EstudanteDTO(Long matricula, int idade, Long turma, String nome) {
        this.matricula = matricula;
        this.idade = idade;
        this.turma = turma;
        this.nome = nome;
    }

    public Estudante converteEstudante(){
        return new Estudante(this.matricula,this.idade,this.turma,this.nome);
    }
    public EstudanteDTO(Estudante e) {
        this.matricula = e.getMatricula();
        this.idade = e.getIdade();
        this.turma = e.getTurma();
        this.nome = e.getNome();
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
