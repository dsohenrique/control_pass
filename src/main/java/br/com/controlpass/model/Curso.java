package br.com.controlpass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_curso")
public class Curso implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_curso")
    private int idCurso;
    
    @Column(name = "qtd_modulo")
    private int qtdModulo;
}
