package br.com.controlpass.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_aluno")
@ManagedBean
public class Aluno implements java.io.Serializable {

    @Id
    @Column(name = "rm")
    private int rm;

    @Column(name = "nome")
    private String nome;

    public Aluno() {
    }

    public int getRm() {
        return rm;
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
    

}
