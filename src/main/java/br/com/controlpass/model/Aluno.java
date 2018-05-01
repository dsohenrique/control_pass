package br.com.controlpass.model;

import java.util.HashSet;
import java.util.Set;

public class Aluno  implements java.io.Serializable {


     private int idAluno;
     private Usuario usuario;
     private int codigoBiometria;
     private Set chamadas = new HashSet(0);


	
    public Aluno(int idAluno, Usuario usuario, int codigoBiometria) {
        this.idAluno = idAluno;
        this.usuario = usuario;
        this.codigoBiometria = codigoBiometria;
    }
    public Aluno(int idAluno, Usuario usuario, int codigoBiometria, Set tblChamadas) {
       this.idAluno = idAluno;
       this.usuario = usuario;
       this.codigoBiometria = codigoBiometria;
       this.chamadas = chamadas;
    }
   
    public int getIdAluno() {
        return this.idAluno;
    }
    
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setTblUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getCodigoBiometria() {
        return this.codigoBiometria;
    }
    
    public void setCodigoBiometria(int codigoBiometria) {
        this.codigoBiometria = codigoBiometria;
    }
    public Set getChamadas() {
        return this.chamadas;
    }
    
    public void setChamadas(Set chamadas) {
        this.chamadas = chamadas;
    }




}


