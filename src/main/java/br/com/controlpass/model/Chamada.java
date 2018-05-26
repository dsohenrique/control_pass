package br.com.controlpass.model;

import java.sql.Date;

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
@Entity
@Table(name = "tbl_chamada")
public class Chamada {

    @Id
    @GeneratedValue
    private int id_chamada;

    @Column(name = "nome_aluno")
    private String nome_aluno;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
//    @Column(name = "hora_inicio")
//    @Temporal(TemporalType.TIME)
//    private Date hora_inicio;
//
//    @Column(name = "hora_final")
//    @Temporal(TemporalType.TIME)
//    private Date hora_final;

    @ManyToOne
    @JoinColumn(name = "id_curso_fk")
    private Curso curso = new Curso();

    @ManyToOne
    @JoinColumn(name = "id_turma_fk")
    private Turma turma = new Turma();

    /*@ManyToOne
	@JoinColumn(name="tipo_usuario")
	private Usuario professor = new Usuario();*/
    @ManyToOne
    @JoinColumn(name = "id_aluno_fk")
    private Aluno aluno = new Aluno();


    /*@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario = new Usuario();*/
    public int getId_chamada() {
        return id_chamada;
    }

    public void setId_chamada(int id_chamada) {
        this.id_chamada = id_chamada;
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
