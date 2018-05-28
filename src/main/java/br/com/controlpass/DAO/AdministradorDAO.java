package br.com.controlpass.DAO;

import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AdministradorDAO extends AbstractDAO {
            public List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> listarUsuario() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT id_usuario, cpf, nome, tipo_usuario, email, status FROM tbl_usuario WHERE status = 1";
        try {
            Connection con = getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuarioAtivo = new Usuario();
                usuarioAtivo.setIdUsuario(rs.getInt("id_usuario"));
                usuarioAtivo.setCpf(rs.getString("cpf"));
                usuarioAtivo.setNome(rs.getString("nome"));
                usuarioAtivo.setTipoUsuario(rs.getString("tipo_usuario"));
                usuarioAtivo.setEmail(rs.getString("email"));
                usuarioAtivo.setStatus(rs.getInt("status"));

                usuarios.add(usuarioAtivo);
                return usuarios;
            }
        } catch (SQLException e) {
            return null;
        } finally {
            closeStatement(stmt);
            closeResultSet(rs);
            closeConnection();
            
        }
        return null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    }
