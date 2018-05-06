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

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_final")
    private String horaFinal;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @ManyToOne
    @JoinColumn(name = "id_curso_fk")
    private Turma curso = new Turma();

    @ManyToOne
    @JoinColumn(name = "id_turma_fk")
    private Turma turma = new Turma();

    /*@ManyToOne
	@JoinColumn(name="tipo_usuario")
	private Usuario professor = new Usuario();*/
    @ManyToOne
    @JoinColumn(name = "id_aluno_fk")
    private Turma aluno = new Turma();

    /*@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario = new Usuario();*/
    public int getId_chamada() {
        return id_chamada;
    }

    public void setId_chamada(int id_chamada) {
        this.id_chamada = id_chamada;
    }
}
