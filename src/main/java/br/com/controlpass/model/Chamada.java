package br.com.controlpass.model;

import java.util.Date;


public class Chamada  implements java.io.Serializable {


     private int idChamada;
     private Aluno aluno;
     private Curso curso;
     private Materia materia;
     private Turma turma;
     private Date data;
     private Date horaInicio;
     private Date horaFinal;


    public Chamada(int idChamada,Aluno aluno, Curso curso, Materia materia, Turma turma, Date data, Date horaInicio, Date horaFinal) {
       this.idChamada = idChamada;
       this.aluno = aluno;
       this.curso = curso;
       this.materia = materia;
       this.turma = turma;
       this.data = data;
       this.horaInicio = horaInicio;
       this.horaFinal = horaFinal;
    }
   
    public int getIdChamada() {
        return this.idChamada;
    }
    
    public void setIdChamada(int idChamada) {
        this.idChamada = idChamada;
    }
    public Aluno getAluno() {
        return this.aluno;
    }
    
    public void setAluno(){
        this.aluno = aluno;
    }
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso Curso) {
        this.curso = curso;
    }
    public Materia getMateria() {
        return this.materia;
    }
    
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    public Turma getTurma() {
        return this.turma;
    }
    
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public Date getHoraInicio() {
        return this.horaInicio;
    }
    
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }
    public Date getHoraFinal() {
        return this.horaFinal;
    }
    
    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }




}


