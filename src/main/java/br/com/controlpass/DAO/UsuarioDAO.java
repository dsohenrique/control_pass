package br.com.controlpass.DAO;

import br.com.controlpass.model.Usuario;
import br.com.controlpass.utils.ShaEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO extends AbstractDAO {

    
    public boolean adiciona(Usuario usuario) {
        
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO tbl_usario(cpf,nome,tipo_usuario, email, status, login, senha) VALUES(?,?,?,?,?,?,?)";
        
        try {
            Connection con = getConnection();
            
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, usuario.getCpf());
            stmt.setString(2, usuario.getNome());
            stmt.setInt(3, usuario.getTipoUsuario());
            stmt.setString(4, usuario.getEmail());
            stmt.setInt(5, usuario.getStatus());
            stmt.setString(6, usuario.getLogin());
            stmt.setString(7, ShaEncoder.encode(usuario.getSenha()));
            
            stmt.execute();
            
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        finally{
            closeStatement(stmt);
            closeConnection();
        }
        
        return false;
    }


    
    
    
}
