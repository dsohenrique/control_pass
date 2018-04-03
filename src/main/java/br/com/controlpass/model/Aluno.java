package br.com.controlpass.model;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TBL_ALUNO")
public class Aluno {

	@Id
	@GeneratedValue
	@Column(name="ID_ALUNO")
	private Long id;
	
	@Column(name="NM_ALUNO")
	private String nome;
	
	@Column(name="TX_CPF")
	private Long cpf;
	
	@Column(name="TX_FONE")
	private String telefone;
	
	@Column(name="TX_EMAIL")
	private String email;
	
	@Column(name="DT_CRIACAO")
	private Date dataCriacao;
	
        private String Endereco;
       	private String ano;
	private String curso;
	//private CursoEnum curso;
	private String modulo;
	//private ModuloEnum curso;
	private String disciplina;
	
	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	
	
	@OneToOne(mappedBy="aluno", cascade = CascadeType.ALL)
	private Endereco endereco = new Endereco();
	
	@PrePersist
	private void preencherDataCriacao(){
		if(dataCriacao == null) {
			dataCriacao = new Date();
		}
		
	}
	
}
	
}
