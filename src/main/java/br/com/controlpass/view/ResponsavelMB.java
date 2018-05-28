package br.com.controlpass.view;

import br.com.controlpass.DAO.ResponsavelDAO;
import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Chamada;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ResponsavelMB {
    public  List<Chamada> presenca = new ArrayList<>();
    public void listar() throws BusinessException {
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        presenca = responsavelDAO.getPresenca();
    }  

    public List<Chamada> getPresenca() {
        return presenca;
    }

    public void setPresenca(List<Chamada> presenca) {
        this.presenca = presenca;
    }
    }
