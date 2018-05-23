package br.com.controlpass.view;

import br.com.controlpass.DAO.UsuarioDAO;
import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class LoginMB {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext()
                .getSession(false);
        session.invalidate();
        return usuario.getNome() + "deslogado com sucesso!";
    }

    public String autenticar() {
        try {
            Usuario usuarioLogado = usuarioDAO.autentica(usuario);
            
            HttpSession session = (HttpSession) FacesContext
                    .getCurrentInstance().getExternalContext().getSession(true);
            
            session.setAttribute("usuario", usuario);
            
            return "layout";
        } catch (BusinessException ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro",
                            ex.getMessage()));
            return "";
        }
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
