package com.target.estudante;

import com.target.estudante.domain.Materia;

public class MateriaDTO {
    private long codigo;
    private String nome;

    public MateriaDTO(long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public MateriaDTO(Materia m) {
        this.codigo = m.getCodigo();
        this.nome = m.getNome();
    }

    public MateriaDTO() {
    }

    public Materia converteMateria(){
        return new Materia(this.codigo,this.nome);
    }
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
