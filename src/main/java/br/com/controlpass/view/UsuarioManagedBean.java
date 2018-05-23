package br.com.controlpass.view;

import br.com.controlpass.DAO.UsuarioDAO;
import br.com.controlpass.model.Usuario;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "UsuarioMB")
public class UsuarioManagedBean {
        

    public String cadastro() throws SQLException {
        Usuario usuario = new Usuario();
        UsuarioDAO con = new UsuarioDAO();
        
        if (con.adiciona(usuario)) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Sucesso!", "Usuário cadastrado com sucesso!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",
                            "Erro no cadastr de usuário!"));

        }
        con.closeConnection();

        return "";
    }

  
}
