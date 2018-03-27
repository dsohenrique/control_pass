package br.com.controlpass.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Presenca extends Aluno {
	
	private String data;
	private String entrada;
	private String saida;
	private String situacao;
	private String totalPresenca;
	

}
