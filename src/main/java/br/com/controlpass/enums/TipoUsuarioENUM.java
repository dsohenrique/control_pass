package br.com.controlpass.enums;

public enum TipoUsuarioENUM {
    
    PROFESSOR("Professor"),
    ADMINISTRADOR("1"),
    RESPONSAVEL("2");

    private String tipoUsuario;

    private TipoUsuarioENUM(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return tipoUsuario;
    }

}
