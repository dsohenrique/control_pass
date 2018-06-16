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
        String sql = "SELECT c.rm_fk, c.nome_aluno, data FROM tbl_chamada c  WHERE rm_fk = ?";
        try {
            Connection con = getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getRm());
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

    public void setPresenca(List<Chamada> presenca) {
        this.presenca = presenca;
    }
    

    public List<Chamada> getPresenca() {
        return presenca;
    }

}
