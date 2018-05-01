package br.com.controlpass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_turma")
public class Turma implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_turma")
    private int idTurma;
    @Column(name = "nm_turma")    
    private String nmTurma;
}
