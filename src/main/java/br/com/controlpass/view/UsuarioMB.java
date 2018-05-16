package br.com.controlpass.view;

import br.com.controlpass.DAO.UsuarioDAO;
import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class UsuarioMB {
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    private Usuario usuario = new Usuario();
    
    public void cadastro() {

        
        try {
            usuarioDAO.adiciona(usuario);
            
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Sucesso!", "Usuário cadastrado com sucesso!"));
        
        } catch (BusinessException ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                            "Erro",
                            ex.getMessage()));    
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
