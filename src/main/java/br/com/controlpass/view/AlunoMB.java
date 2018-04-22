package br.com.controlpass.view;

import br.com.controlpass.model.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@ManagedBean

public class AlunoMB {

    private String cpf ;

    public String consultar() {
        if (cpf.equals("12345")) {
            //return FacesContext.getCurrentInstance().getExternalContext().redirect("DadosALuno.xhtml");
            return "pagina?faces-redirect=true";
        } else {
            return "CPF inv�lido";
        }
    }
    private Aluno edit = new Aluno();
    private List<Aluno> registros;

    @PostConstruct
    public void postConstruct() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ETEC");
        EntityManager em = emf.createEntityManager();
        String sql = "SELECT a FROM Aluno a";
        TypedQuery<Aluno> query = em.createQuery(sql, Aluno.class);
        registros = query.getResultList();
    }

    public void doSave() {
        try {
            Thread.sleep(8000);
            //edit.getEndereco().setAluno(edit);

            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("ETEC");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(edit);
            em.getTransaction().commit();
            em.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Regsitro inserido com sucesso.",
                    null));
            edit = new Aluno();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<Aluno> alunos = new ArrayList<Aluno>();
    // private List<Presenca> presencas = new ArrayList<Presenca>();
    private Aluno exibicao = new Aluno();

    // private Presenca exibicao1 = new Presenca();

   
    public void doView(Aluno alu) {
        // Busca no banco de dados pelo ID
        exibicao = alu;
    }

    // public void verificarCpf(Aluno cpf){
    // }
    // }
    
  }
