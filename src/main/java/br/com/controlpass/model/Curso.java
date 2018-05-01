package br.com.controlpass.model;



import java.util.HashSet;
import java.util.Set;


public class Curso  implements java.io.Serializable {


     private int idCurso;
     private int qtdModulo;
     private Set chamadas = new HashSet(0);
     private Set turmas = new HashSet(0);

    public Curso() {
    }

	
    public Curso(int idCurso, int qtdModulo) {
        this.idCurso = idCurso;
        this.qtdModulo = qtdModulo;
    }
    public Curso(int idCurso, int qtdModulo, Set tblChamadas, Set tblTurmas) {
       this.idCurso = idCurso;
       this.qtdModulo = qtdModulo;
       this.chamadas = chamadas;
       this.turmas = turmas;
    }
   
    public int getIdCurso() {
        return this.idCurso;
    }
    
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    public int getQtdModulo() {
        return this.qtdModulo;
    }
    
    public void setQtdModulo(int qtdModulo) {
        this.qtdModulo = qtdModulo;
    }
    public Set getChamadas() {
        return this.chamadas;
    }
    
    public void setChamadas(Set chamadas) {
        this.chamadas = chamadas;
    }
    public Set getTblTurmas() {
        return this.turmas;
    }
    
    public void setTblTurmas(Set turmas) {
        this.turmas = turmas;
    }




}


