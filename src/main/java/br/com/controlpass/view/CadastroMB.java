package br.com.controlpass.view;

import br.com.controlpass.dao.HibernateUtil;
import br.com.controlpass.model.Usuario;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@ManagedBean
public class CadastroMB {
    
    public void cadastrar(){  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
    Usuario usuario = new Usuario();
    usuario.setCpf(0);
    usuario.setNome("nome");
    usuario.setTipoUsuario(0);
    usuario.setEmail("email");
    usuario.setStatus(0);
    usuario.setLogin("login");
    usuario.setSenha("senha");
    
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(usuario);
        tx.commit();
        session.flush();
        session.close();
    
    }
    
}
