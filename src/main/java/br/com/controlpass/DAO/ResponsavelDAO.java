package br.com.controlpass.DAO;

import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Chamada;
import br.com.controlpass.model.Usuario;
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
        String sql = "SELECT a.rm, nome_aluno, u.rm, u.cpf, u.tipo_usuario, data, hora_inicio, hora_final FROM tbl_aluno a INNER JOIN tbl_usuario u ON a.rm = u.rm INNER JOIN tbl_chamada c ON c.rm = a.rm  WHERE ? = a.rm AND u.tipo_usuario = 2;";
        try {
            Connection con = getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getRm());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Chamada chamada = new Chamada();
                chamada.setRm(rs.getInt("rm"));
                chamada.setNome(rs.getString("nome_aluno"));
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

    public void setPresenca(List<Chamada> presenca) {
        this.presenca = presenca;
    }
    

    public List<Chamada> getPresenca() {
        return presenca;
    }

}
