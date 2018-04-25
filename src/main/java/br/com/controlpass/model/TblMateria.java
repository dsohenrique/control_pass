package br.com.controlpass.model;
// Generated 24/04/2018 21:53:31 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TblMateria generated by hbm2java
 */
public class TblMateria  implements java.io.Serializable {


     private int idMateria;
     private String nmMateria;
     private Set tblChamadas = new HashSet(0);

    public TblMateria() {
    }

	
    public TblMateria(int idMateria, String nmMateria) {
        this.idMateria = idMateria;
        this.nmMateria = nmMateria;
    }
    public TblMateria(int idMateria, String nmMateria, Set tblChamadas) {
       this.idMateria = idMateria;
       this.nmMateria = nmMateria;
       this.tblChamadas = tblChamadas;
    }
   
    public int getIdMateria() {
        return this.idMateria;
    }
    
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    public String getNmMateria() {
        return this.nmMateria;
    }
    
    public void setNmMateria(String nmMateria) {
        this.nmMateria = nmMateria;
    }
    public Set getTblChamadas() {
        return this.tblChamadas;
    }
    
    public void setTblChamadas(Set tblChamadas) {
        this.tblChamadas = tblChamadas;
    }




}

