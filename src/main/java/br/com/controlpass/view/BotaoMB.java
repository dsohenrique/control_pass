package br.com.controlpass.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
public class BotaoMB {

    public void msgRecuperaSenha(ActionEvent actionEvent) {
        addMessage("Nova senha enviada por Email!");
    }
    public void msgLogOff(ActionEvent actionEvent) {
        addMessage("Até mais!");
    }
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
