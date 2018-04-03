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
import java.util.ArrayList;

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
        private String cpf = "";

	public String consultar() {
		if (cpf.equals("12345")) {
			//return FacesContext.getCurrentInstance().getExternalContext().redirect("DadosALuno.xhtml");
			 return "pagina?faces-redirect=true";
		}
		else{
			return "CPF inv�lido";
		}
	}
	
	private List<Aluno> alunos = new ArrayList<Aluno>();
	// private List<Presenca> presencas = new ArrayList<Presenca>();
	private Aluno exibicao = new Aluno();

	// private Presenca exibicao1 = new Presenca();
        
        private List<Presenca> presencas = new ArrayList<Presenca>();
	private Presenca exibicao1 = new Presenca();
        
	@PostConstruct
	public void postConstruct() {
		findAll();
		exibicao.setNome("Lucas");
	}

	private void findAll() {
		Aluno alu1 = new Aluno();
		//alu1.setNome("Lucas");
		alu1.setCpf("12345");
		alu1.setAno("2018");
		/*alu1.setCurso(CursoEnum.Selecione);
		alu1.setCurso(CursoEnum.INFORM�TICA);
		alu1.setCurso(CursoEnum.ADMINISTRA��O);
		alu1.setCurso(CursoEnum.ELETR�NICA);
		alu1.setCurso(CursoEnum.REDES);
		alu1.setCurso(CursoEnum.MECATR�NICA);
		alu1.setModulo(ModuloEnum.Selecione);
		alu1.setModulo(ModuloEnum.PRIMEIRO);
		alu1.setModulo(ModuloEnum.SEGUNDO);
		alu1.setModulo(ModuloEnum.TERCEIRO);*/
		alu1.setCurso("Selecione");
		alu1.setCurso("INFORM�TICA");
		alu1.setCurso("ADMINISTRA��O");
		alu1.setCurso("ELETR�NICA");
		alu1.setCurso("REDES");
		alu1.setCurso("MECATR�NICA");
		alu1.setModulo("Selecione");
		alu1.setModulo("PRIMEIRO");
		alu1.setModulo("SEGUNDO");
		alu1.setModulo("TERCEIRO");
		alu1.setDisciplina("T�CNICAS PROGRAMA��O INTERNET II");                
               /* Postconstruct PRESENÇA*/
                Presenca presenca = new Presenca();
		presenca.setNome("Lucas");
		presenca.setData("05/03/2018");
		presenca.setEntrada("19:00");
		presenca.setSaida("20:50");
		presenca.setSituacao("Presente");
		presenca.setTotalPresenca("68%");
		
		presencas.add(presenca);

		/*
		 * Presenca alu2 = new Presenca(); alu2.setNome("Lucas");
		 * alu2.setData("05/03/2018"); alu2.setEntrada("19:00");
		 * alu2.setSaida("20:50"); alu2.setSituacao("Presente");
		 */

		alunos.add(alu1);
		// presencas.add(alu2);
	}

	public void doView(Aluno alu) {
		// Busca no banco de dados pelo ID
		exibicao = alu;
	}
        public void doView(Presenca presenca) {
		//Busca no banco de dados pelo ID
		exibicao1 = presenca;
	}

	// public void verificarCpf(Aluno cpf){

	// }
	// }
        

}