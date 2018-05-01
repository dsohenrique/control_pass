package br.com.controlpass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_usuario")
public class Usuario implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_usuario")
    private int idUsuario;
    
    @Column(name = "cpf")
    private int cpf;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "tipo_usuario")
    private int tipoUsuario;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "status")
    private int status;
    
    @Column(name = "login")
    private String login;
    
    @Column(name = "senha")
    private String senha;
}
