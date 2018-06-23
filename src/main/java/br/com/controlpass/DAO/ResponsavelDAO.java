package br.com.controlpass.DAO;

import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Chamada;
import br.com.controlpass.model.Usuario;
import br.com.controlpass.utils.ShaEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ResponsavelDAO extends AbstractDAO {

    public List<Chamada> presenca = new ArrayList<>();

    public List<Chamada> getPresencas(Usuario usuario) throws BusinessException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.rm_fk, c.nome_aluno, data FROM tbl_chamada c INNER JOIN tbl_usuario u ON c.rm_fk = u.rm AND u.cpf = ?";
        try {
            Connection con = getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getCpf());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Chamada chamada = new Chamada();
                chamada.setRm(rs.getInt("rm_fk"));
                chamada.setNome(rs.getString("nome_aluno"));
                chamada.setData(rs.getDate("data"));
                presenca.add(chamada);
            }
        } catch (SQLException e) {
            return null;
        } finally {
            closeStatement(stmt);
            closeResultSet(rs);
            closeConnection();
        }
        return presenca;

    }

    public void setSenha(Usuario usuario) throws BusinessException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "UPDATE tbl_usuario SET senha = ? WHERE cpf = ?";
        try {
            Connection con = getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ShaEncoder.encode(usuario.getSenha()));
            stmt.setString(2, usuario.getCpf());
            stmt.executeUpdate();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            closeStatement(stmt);
            closeResultSet(rs);
            closeConnection();
        }

    }

    public void setPresenca(List<Chamada> presenca) {
        this.presenca = presenca;
    }

    public List<Chamada> getPresenca() {
        return presenca;
    }

}
