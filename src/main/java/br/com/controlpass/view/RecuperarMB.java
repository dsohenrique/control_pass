package br.com.controlpass.view;

import br.com.controlpass.DAO.RecuperarDAO;
import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class RecuperarMB {
    
    RecuperarDAO recuperarDAO = new RecuperarDAO();
    Usuario usuario = new Usuario();
    
    public void resetaSenha() throws BusinessException {
        try {
            recuperarDAO.reset(usuario);
            addMessage("Senha resetada para controlpass!");
        }    
         catch (BusinessException ex) {
              FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Não encontrei o cpf!",
                            ex.getMessage()));
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public RecuperarDAO getRecuperarDAO() {
        return recuperarDAO;
    }

    public void setRecuperarDAO(RecuperarDAO recuperarDAO) {
        this.recuperarDAO = recuperarDAO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    }
