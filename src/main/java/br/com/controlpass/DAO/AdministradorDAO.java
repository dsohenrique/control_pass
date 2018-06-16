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
        String sql = "SELECT u.id_usuario, u.rm, u.cpf, u.nome, t.tipo ,u.email, s.status FROM tbl_usuario u INNER JOIN tbl_status s ON u.status = s.id INNER JOIN tbl_tipo t ON u.tipo_usuario = t.id";
        try {
            Connection con = getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuarioAtivo = new Usuario();
                usuarioAtivo.setIdUsuario(rs.getInt("id_usuario"));
                usuarioAtivo.setRm(rs.getInt("rm"));
                usuarioAtivo.setCpf(rs.getString("cpf"));
                usuarioAtivo.setNome(rs.getString("nome"));
                usuarioAtivo.setTipoUsuario(rs.getString("tipo"));
                usuarioAtivo.setEmail(rs.getString("email"));
                usuarioAtivo.setStatus(rs.getString("status"));

                usuarios.add(usuarioAtivo);
            }
        } catch (SQLException e) {
            return null;
        } finally {
            closeStatement(stmt);
            closeResultSet(rs);
            closeConnection();
        }
            return usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
