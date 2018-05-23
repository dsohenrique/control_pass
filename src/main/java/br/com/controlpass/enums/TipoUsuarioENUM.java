package br.com.controlpass.enums;

public enum TipoUsuarioENUM {
    
    ALUNO("Aluno"),
    PROFESSOR("Professor"),
    ADMINISTRADOR("Administrador"),
    RESPONSAVEL("Responsavel");

    private String tipoUsuario;

    private TipoUsuarioENUM(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return tipoUsuario;
    }

}
