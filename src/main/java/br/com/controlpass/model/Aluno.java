package br.com.controlpass.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;



//import br.com.controlpass.enums.CursoEnum;
//import br.com.controlpass.enums.ModuloEnum;


@Getter
@Setter
public class Aluno {

	private Long id;
	private String nome;
	private String cpf;
        private String email;
        private Date nascimento; /* mudar de String para Date*/
	private String ano;
	private String curso;
	//private CursoEnum curso;
	private String modulo;
	//private ModuloEnum curso;
	private String disciplina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
	
	
}
