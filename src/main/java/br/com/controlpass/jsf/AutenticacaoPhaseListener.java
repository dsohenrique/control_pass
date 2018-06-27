package br.com.controlpass.jsf;

import br.com.controlpass.model.Usuario;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AutenticacaoPhaseListener implements PhaseListener{
    
    private static final String[] safePages = {"Inicial","error","accessoNegado"};//TODO: Acesso negado
    
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
                    navigationHandler.handleNavigation(facesContext, null, "accessoNegado");
                }
            }
        }
    }
    
    public boolean temPermissao(String pagina, Usuario usuario){
        
        return true; // TODO: implementar
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
