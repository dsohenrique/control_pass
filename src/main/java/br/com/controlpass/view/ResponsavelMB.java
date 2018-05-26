package br.com.controlpass.view;

import br.com.controlpass.DAO.ResponsavelDAO;
import br.com.controlpass.model.Chamada;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ResponsavelMB {
    public  List<Chamada> presenca = new ArrayList<>();
    public void listar() {
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        presenca = responsavelDAO.getPresenca();
    }
//    }
//    private List<Chamada> presenca;
//    
//    @ManagedProperty("#{responsavelDAO}")
//    private ResponsavelDAO responsavelDAO;
//    
//    public List<Chamada> getPresenca(){
//        return presenca;
//    }
//
//    public void setPresenca(List<Chamada> presenca) {
//        this.presenca = presenca;
//    }
//    
//    public void init(){
//        presenca = responsavelDAO.getPresenca();
//    }
//
//    public void setResponsavelDAO(ResponsavelDAO responsavelDAO) {
//        this.responsavelDAO = responsavelDAO;
//    }
    
//    

    public List<Chamada> getPresenca() {
        return presenca;
    }

    public void setPresenca(List<Chamada> presenca) {
        this.presenca = presenca;
    }
    }
