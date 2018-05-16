package br.com.controlpass.view;

import br.com.controlpass.DAO.UsuarioDAO;
import br.com.controlpass.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class UsuarioMB {
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    private Usuario usuario = new Usuario();
    
    public String cadastro() {

        if (usuarioDAO.adiciona(usuario)) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Sucesso!", "Usuário cadastrado com sucesso!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",
                            "Erro no cadastr de usuário!"));

        }
         return "";
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
