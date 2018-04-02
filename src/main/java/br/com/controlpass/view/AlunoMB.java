package br.com.etechoracio.jpa.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import lombok.Getter;
import lombok.Setter;
import br.com.etechoracio.jpa.model.Aluno;

@Getter
@Setter
@ManagedBean
public class AlunoMB {

	private Aluno edit = new Aluno();
	private List<Aluno> registros;

	@PostConstruct
	public void postConstruct() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ETEC");
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT a FROM Aluno a";
		TypedQuery<Aluno> query = em.createQuery(sql, Aluno.class);
		setRegistros(query.getResultList());
	}

	public void doSave() {
		try {
			Thread.sleep(8000);
			edit.getEndereco().setAluno(edit);

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ETEC");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(edit);
			em.getTransaction().commit();
			em.close();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Regsitro inserido com sucesso.", null));
			edit = new Aluno();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<Aluno> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Aluno> registros) {
		this.registros = registros;
	}

}