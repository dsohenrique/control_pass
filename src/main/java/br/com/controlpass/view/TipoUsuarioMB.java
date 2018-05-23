package br.com.controlpass.view;

import br.com.controlpass.model.Usuario;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

public class TipoUsuarioMB {
    private String tipoUsuario;
    private Map<String,String> tipos = new HashMap<String, String>();
    @PostConstruct
    public void init() {
        tipos.put("ADMINISTRADOR", "ADMINISTRADOR");
        tipos.put("ALUNO", "ALUNO");
        tipos.put("RESPONSAVEL", "RESPONSAVEL");
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Map<String, String> getTipos() {
        return tipos;
    }

    public void setTipos(Map<String, String> tipos) {
        this.tipos = tipos;
    }
    
}
