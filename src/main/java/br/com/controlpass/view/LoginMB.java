
package br.com.controlpass.view;

import br.com.controlpass.enums.TipoUsuarioENUM;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@ManagedBean
@Entity
@Table(name = "login")
public class LoginMB {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "login")
    private String login ;
    @Column(name = "senha")
    private String senha ;
    @Column(name = "tipo_usuario")
    private Usuario usuario;
    private TipoUsuarioENUM[] tipoUsuarioENUM;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        tipoUsuarioENUM = TipoUsuarioENUM.values();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoUsuarioENUM[] getTipoUsuarioENUM() {
        return tipoUsuarioENUM;
    }

    public void setTipoUsuarioENUM(TipoUsuarioENUM[] tipoUsuarioENUM) {
        this.tipoUsuarioENUM = tipoUsuarioENUM;
    }

   
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        public String logar() {
        if (login.equals("TEST")
                && senha.equals("123")
                && tipoUsuarioENUM.equals("ALUNO")) {
            return "bemVindo";
        }
        return null;
    }
        
    
    }
 
    

