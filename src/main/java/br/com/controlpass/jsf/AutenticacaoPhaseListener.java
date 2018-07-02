package br.com.controlpass.jsf;

import br.com.controlpass.enums.TipoUsuarioENUM;
import br.com.controlpass.model.Usuario;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AutenticacaoPhaseListener implements PhaseListener{
    
    
    private static final String[] administradorPages = {"index", "save", "save2", "TelaValidarUsuario", "recuperar", "TelaInativarUsuario"};
    private static final String[] responsavelPages = {"inicialResponsavel"};
    
    private static final String[] safePages = {"Inicial","error","acessoNegado", "novaSenha"};
    
    @Override
    public void afterPhase(PhaseEvent event) {
    }

    @Override
    public void beforePhase(PhaseEvent event) {

        PhaseId phase = event.getPhaseId();

        if (phase == PhaseId.RENDER_RESPONSE) {

            FacesContext facesContext = event.getFacesContext();
            HttpSession session = (HttpSession) facesContext
                    .getExternalContext().getSession(true);

            Usuario usuario = (Usuario) session.getAttribute("usuario");

            if (usuario == null) {
                
                NavigationHandler navigationHandler = facesContext
                        .getApplication().getNavigationHandler();
                navigationHandler.handleNavigation(facesContext, null, "Inicial");
                
            } else {
                
                String viewId = facesContext.getViewRoot().getViewId()
                        .replace(".xhtml", "").replace("/pages/", "");
                
                if (!isSafePage(viewId) && 
                        !temPermissao(viewId, usuario)) {
                    
                    NavigationHandler navigationHandler = facesContext
                            .getApplication().getNavigationHandler();
                    navigationHandler.handleNavigation(facesContext, null, "acessoNegado");
                }
            }
        }
    }
    
    public boolean temPermissao(String pagina, Usuario usuario){      
        
        if (usuario.getTipoUsuario().equals(TipoUsuarioENUM.ADMINISTRADOR.toString())) {
            for(String paginaAcesso : administradorPages){
                if(pagina.equals(paginaAcesso)){
                    return true;
                }
            }
        }
        else if (usuario.getTipoUsuario().equals(TipoUsuarioENUM.RESPONSAVEL.toString())) {
            for(String paginaAcesso : responsavelPages){
                if(pagina.equals(paginaAcesso)){
                    return true;
                }
            }
        } 
        return false;
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
    private boolean isSafePage(String outcome){
        for(String safePage : safePages){
            if(safePage.equals(outcome)){
                return true;
            }
        }
        return false;
    }
    
}
