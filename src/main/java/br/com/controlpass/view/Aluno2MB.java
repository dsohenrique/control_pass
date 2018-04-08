package br.com.controlpass.view;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

//import br.com.controlpass.responsavel.model.Aluno;

import br.com.controlpass.model.Presenca;
import lombok.Getter;
import lombok.Setter;




@ManagedBean
@Getter
@Setter
public class Aluno2MB {
	
	public List<Presenca> getPresencas() {
		return presencas;
	}

	public void setPresencas(List<Presenca> presencas) {
		this.presencas = presencas;
	}

	public Presenca getExibicao1() {
		return exibicao1;
	}

	public void setExibicao1(Presenca exibicao1) {
		this.exibicao1 = exibicao1;
	}

	private List<Presenca> presencas = new ArrayList<Presenca>();
	private Presenca exibicao1 = new Presenca();
	
	@PostConstruct
	public void postConstruct() {
		findAll();
	}
	
	public void findAll(){
		
		Presenca presenca = new Presenca();
		presenca.setNome("Lucas");
		presenca.setData("05/03/2018");
		presenca.setEntrada("19:00");
		presenca.setSaida("20:50");
		presenca.setSituacao("Presente");
		presenca.setTotalPresenca("68%");
		
		presencas.add(presenca);
	}
	
	public void doView(Presenca presenca) {
		//Busca no banco de dados pelo ID
		exibicao1 = presenca;
	}
	
}
