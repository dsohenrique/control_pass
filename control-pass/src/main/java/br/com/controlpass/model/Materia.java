package br.com.controlpass.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_aluno")
public class Materia  implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_materia")
     private int idMateria;
     
    @Column(name = "nm_materia")
     private String nmMateria;
     }


