package br.com.controlpass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_aluno")
public class Aluno implements java.io.Serializable{
    @Id
    @Column(name = "id_aluno")
     private int idAluno;
    @Column(name = "codigo_biometria")
     private int codigoBiometria;

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
    
}


