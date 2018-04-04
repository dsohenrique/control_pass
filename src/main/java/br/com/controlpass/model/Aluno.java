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
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	@Column(name="NM_ALUNO")
	private String nome;
	
	@Column(name="TX_CPF")
	private int cpf;
	
	@Column(name="TX_FONE")
	private String telefone;
	
	@Column(name="TX_EMAIL")
	private String email;
	
	private Date nascimento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
}
