package br.com.controlpass.model;



//import br.com.controlpass.enums.CursoEnum;
//import br.com.controlpass.enums.ModuloEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {

	private int id;
	private String nome;
	private String cpf;
	private String ano;
	private String curso;
	//private CursoEnum curso;
	private String modulo;
	//private ModuloEnum curso;
	private String disciplina;
	
	
}
