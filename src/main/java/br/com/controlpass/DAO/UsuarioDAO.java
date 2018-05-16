package br.com.controlpass.DAO;

import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Usuario;
import br.com.controlpass.utils.ShaEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends AbstractDAO {

    
    public void adiciona(Usuario usuario) throws BusinessException {
        
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO tbl_usuario(cpf,nome,tipo_usuario, email, status, login, senha) VALUES(?,?,?,?,?,?,?)";
        
        try {
            Connection con = getConnection();
            
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, usuario.getCpf());
            stmt.setString(2, usuario.getNome());
            stmt.setInt(3, usuario.getTipoUsuario());
            stmt.setString(4, usuario.getEmail());
            stmt.setInt(5, usuario.getStatus());
            stmt.setString(6, usuario.getLogin());
            stmt.setString(7, ShaEncoder.encode(usuario.getSenha()));
            
            stmt.execute();
            
        } catch (SQLException u) {
//            if(u.getErrorCode() == 1){
//                throw new BusinessException("Usuario ja cadastrado");
//            }
            throw new RuntimeException(u);
        }
        finally{
            closeStatement(stmt);
            closeConnection();
        }
        
    }
     public Usuario autentica(Usuario usuario) throws BusinessException {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT id_usuario, cpf,nome,tipo_usuario, email, status, login, senha FROM tbl_usuario WHERE login = ?";
        
        try {
            Connection con = getConnection();
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Usuario usuarioEncontrado = new Usuario();
                usuarioEncontrado.setCpf(rs.getString("cpf"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setTipoUsuario(rs.getInt("tipo_usuario"));
                usuarioEncontrado.setEmail(rs.getString("email"));
                usuarioEncontrado.setStatus(rs.getInt("status"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                
                if (!ShaEncoder.encode(usuario.getSenha()).equals(usuarioEncontrado.getSenha())) {
                     throw new BusinessException("Usuario ou Senha invalidos!");
                }
                
                return usuarioEncontrado;
            }
            else{
                throw new BusinessException("Usuario ou Senha invalidos!");
            }
            
        } catch (SQLException u) {
//            if(u.getErrorCode() == 1){
//                throw new Exception("Usuario ja cadastrado");
//            }
            throw new RuntimeException(u);
        }
        finally{
            closeStatement(stmt);
            closeResultSet(rs);
            closeConnection();
        }
        
    }

}

