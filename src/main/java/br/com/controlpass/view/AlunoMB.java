package br.com.controlpass.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
//import br.com.controlpass.enums.CursoEnum;
//import br.com.controlpass.enums.ModuloEnum;
import br.com.controlpass.model.Aluno;
import lombok.Getter;
import lombok.Setter;


@ManagedBean
@Getter
@Setter
public class AlunoMB {

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
		alu1.setCurso("INFORMATICA");
		alu1.setCurso("ADMINISTRACAO");
		alu1.setCurso("ELETRONICA");
		alu1.setCurso("REDES");
		alu1.setCurso("MECATRONICA");
		alu1.setModulo("Selecione");
		alu1.setModulo("PRIMEIRO");
		alu1.setModulo("SEGUNDO");
		alu1.setModulo("TERCEIRO");
		alu1.setDisciplina("T�CNICAS PROGRAMA��O INTERNET II");

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

	// public void verificarCpf(Aluno cpf){

	// }
	// }

}
