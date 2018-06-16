package br.com.controlpass.view;

import br.com.controlpass.DAO.AdministradorDAO;
import br.com.controlpass.DAO.ResponsavelDAO;
import br.com.controlpass.DAO.UsuarioDAO;
import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Chamada;
import br.com.controlpass.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

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

    public List<Usuario> listaUsuario = new ArrayList<>();

    public void listar() throws BusinessException {
        listaUsuario.add(usuario);
    }

    public void onRowEdit(){
        try {
            usuarioDAO.altera(usuario);
            
        } catch (BusinessException ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro",
                            ex.getMessage()));
        }
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

}
