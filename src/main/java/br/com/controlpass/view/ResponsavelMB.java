package br.com.controlpass.view;

import br.com.controlpass.DAO.ResponsavelDAO;
import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ResponsavelMB {
    
//    public void listar() throws BusinessException {
//        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
//    try {
//         responsavelDAO.getPresencas(usuario);
//        } catch (BusinessException ex) {
//            FacesContext.getCurrentInstance().addMessage(
//                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                            "Erro",
//                            ex.getMessage()));
//        }
//        
//    }
}
