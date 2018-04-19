package br.com.controlpass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue
	@Column(name="ID_ENDERECO")
	private Long id;
	
	@Column(name="TX_LOGRADOURO")
	private String logradouro;
	
	@Column(name="NR_LOGRADOURO")
	private Long numero;
	
	@Column(name="TX_COMPLEMENTO")
	private String complemento;
	
	@Column(name="TX_BAIRRO")
	private String bairro;
	
	@Column(name="TX_CIDADE")
	private String cidade;
	
	@Column(name="TX_UF")
	private String uf;
	
	@Column(name="TX_CEP")
	private String cep;
	
	@OneToOne
	@JoinColumn(name="ID_ALUNO")
	private Aluno aluno;
	
	@PrePersist
	private void preencherUF(){
		if (uf == null) {
			uf = "SP";
		}
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
         
}
