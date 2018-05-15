package br.com.controlpass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="tbl_aluno")
public class Aluno implements java.io.Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id_aluno")
    private int idAluno;

    @Column(name = "codigo_biometria")
    private int codigoBiometria;

    @Transient
    @ManyToOne
    @JoinColumn(name="")
    private Usuario usuario;
    
    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getCodigoBiometria() {
        return codigoBiometria;
    }

    public void setCodigoBiometria(int codigoBiometria) {
        this.codigoBiometria = codigoBiometria;
    }

    public Aluno(int idAluno) {
        this.idAluno = idAluno;
    }

	public Aluno() {
	}
    
    
}


