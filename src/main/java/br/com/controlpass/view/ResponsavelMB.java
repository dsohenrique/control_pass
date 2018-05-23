package br.com.controlpass.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import br.com.controlpass.model.Chamada;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ResponsavelMB {
    private List<Chamada> chamadas = new ArrayList<Chamada>();
    private Chamada exibicao = new Chamada();

    public List<Chamada> getChamadas() {
        return chamadas;
    }

    public void setChamadas(List<Chamada> Chamadas) {
        this.chamadas = Chamadas;
    }

    public Chamada getExibicao() {
        return exibicao;
    }

    public void setExibicao(Chamada exibicao) {
        this.exibicao = exibicao;
    }

    @PostConstruct
    public void postConstruct(){
        findAll();
    }
    private void findAll(){
        Chamada chamada = new Chamada();
        chamada.getAluno();
        
        
    }
    
}
