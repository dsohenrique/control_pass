package br.com.controlpass.view;

import br.com.controlpass.model.Aluno;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
public class TesteMB {

	
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private Aluno exibicao = new Aluno();

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno getExibicao() {
		return exibicao;
	}

	public void setExibicao(Aluno exibicao) {
		this.exibicao = exibicao;
	}

	@PostConstruct
	public void postConstruct() {
		findAll();
	}
	
	private void findAll(){
		Aluno alu2 = new Aluno();
		alu2.setId(2L);
		alu2.setEmail("joelshemale@gmail.com");
		alu2.setNome("Joel Alberto");
		alu2.setNascimento(new Date());
		/*alu2.setNascimento("16/08/1999"); - Mudar 'Nascimento' para String na Classe Aluno*/
		
		Aluno alu1 = new Aluno();
		alu1.setId(1L);
		alu1.setEmail("gustavosilvaborges1608@hotmail.com");
		alu1.setNome("Gustavo");
		alu1.setNascimento(new Date());
		
		alunos.add(alu1);
		alunos.add(alu2);
		
		/*
		 * 
		 */
	}
	
	public void doView(Aluno alu) {
		//Busca no banco de dados pelo ID
		exibicao = alu;
	}
	
}
