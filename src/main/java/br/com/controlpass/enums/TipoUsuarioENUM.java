
package br.com.controlpass.enums;

public enum TipoUsuarioENUM {
    ALUNO,
    PROFESSOR,
    ADMNISTRADOR,
    RESPONSAVEL;
   
    public static TipoUsuarioENUM getALUNO() {    
        return ALUNO;
    }

    public static TipoUsuarioENUM getPROFESSOR() {
        return PROFESSOR;
    }

    public static TipoUsuarioENUM getADMNISTRADOR() {
        return ADMNISTRADOR;
    }

    public static TipoUsuarioENUM getRESPONSAVEL() {
        return RESPONSAVEL;
    }
}
