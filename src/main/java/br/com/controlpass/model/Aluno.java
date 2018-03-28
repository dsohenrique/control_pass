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

//import br.com.controlpass.enums.CursoEnum;
//import br.com.controlpass.enums.ModuloEnum;
@Getter
@Setter
@Entity
@Table(name = "TBL_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue
    @Column(name = "ID_ALUNO")
    private Long id;
    private String aluno;
    @Column(name = "NM_ALUNO")
    private String nome;
    @Column(name = "TX_CPF")
    private Long cpf;
    @Column(name = "TX_FONE")
    private String telefone;
    @Column(name = "TX_EMAIL")
    private String email;
    private Date nascimento;
    /* mudar de String para Date*/
    private String ano;
    private String curso;
    //private CursoEnum curso;
    private String modulo;
    //private ModuloEnum curso;
    private String disciplina;
    @Column(name = "DT_CRIACAO")
    private Date dataCriacao;
    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    private br.com.controlpass.model.Endereco endereco = new br.com.controlpass.model.Endereco();

    @PrePersist
    private void preencherDataCriacao() {
        if (dataCriacao == null) {
            dataCriacao = new Date();
        }
    }
    

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

    public Object getEndereco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCpf(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
