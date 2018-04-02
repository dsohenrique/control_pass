import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {
	
	private Long id;
	private String nome;
	private String email;
	private Date nascimento; /* mudar de String para Date*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
}
