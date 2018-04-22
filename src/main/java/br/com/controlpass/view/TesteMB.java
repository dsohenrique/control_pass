package br.com.controlpass.view;

import br.com.controlpass.model.Usuario;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TesteMB {

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private Usuario exibicao = new Usuario();

    public List<Usuario> getusuarios() {
        return usuarios;
    }

    public void setusuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getExibicao() {
        return exibicao;
    }

    public void setExibicao(Usuario exibicao) {
        this.exibicao = exibicao;
    }

    @PostConstruct
    public void postConstruct() {
        findAll();
    }

    private void findAll() {
        Usuario usuario = new Usuario();
        usuario.setEmail("joelshemale@gmail.com");
        usuario.setNome("Joel Alberto");
        
        Usuario usuario2 = new Usuario();
        usuario2.setEmail("gustavosilvaborges1608@hotmail.com");
        usuario2.setNome("Gustavo");

        usuarios.add(usuario);
        usuarios.add(usuario);

        /*
		 * 
         */
    }

    public void doView(Usuario usuario) {
        //Busca no banco de dados pelo ID
        exibicao = usuario;
    }

}
