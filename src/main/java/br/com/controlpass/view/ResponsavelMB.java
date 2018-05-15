package br.com.controlpass.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.controlpass.DAO.UsuarioDAO;
import br.com.controlpass.model.Usuario;

@ManagedBean


public class ResponsavelMB {
	
	private UsuarioDAO usuarioDAO;
	private int cpf;
	
	@PostConstruct
	public void postConstruct() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Connection");
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT cpf FROM tbl_usuario WHERE cpf = Usuario.getCpf()";
	}
	
	public String consultar() {
		Usuario usuario = new Usuario();
		if (usuarioDAO.getCPF(usuario) == cpf) {
			//return FacesContext.getCurrentInstance().getExternalContext().redirect("DadosALuno.xhtml");
			 return "pagina?faces-redirect=true";
		}
		else{
			return "CPF inválido";
		}
	}

}
