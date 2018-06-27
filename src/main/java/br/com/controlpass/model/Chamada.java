package br.com.controlpass.model;

import java.sql.Date;
import javax.faces.bean.ManagedBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tbl_chamada")
@ManagedBean
public class Chamada {

    @Id
    @GeneratedValue
    private int id_chamada;

    @Column(name = "nome_aluno")
    private String nome_aluno;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    
    private String nome_materia;
    
    private String nome_curso;
    
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private String hora_inicio;

    @Column(name = "hora_final")
    @Temporal(TemporalType.TIME)
    private String hora_final;
//    @ManyToOne
//    @JoinColumn(name = "id_curso_fk")
//    private Curso curso = new Curso();

    @ManyToOne
    @JoinColumn(name = "id_turma_fk")
    private Turma turma = new Turma();
    @Id
    @Column(name = "rm")
    private int rm;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "situacao")
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    
    public int getId_chamada() {
        return id_chamada;
    }

    public void setId_chamada(int id_chamada) {
        this.id_chamada = id_chamada;
    }

    public String getNome_materia() {
        return nome_materia;
    }

    public void setNome_materia(String nome_materia) {
        this.nome_materia = nome_materia;
    }

    public String getNome_curso() {
        return nome_curso;
    }

//    public Curso getCurso() {
//        return curso;
//    }
//
//    public void setCurso(Curso curso) {
//        this.curso = curso;
//    }
    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public void setRm(int rm) {
        this.rm = rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}
