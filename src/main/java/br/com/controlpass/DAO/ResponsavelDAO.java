package br.com.controlpass.DAO;

import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Chamada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsavelDAO extends AbstractDAO {

    public List<Chamada> getPresenca() throws BusinessException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT id_aluno, nome, data, hora_inicio, hora_final FROM tbl_aluno a INNER JOIN tbl_usuario u ON u.id_usuario = a.id_usuario_fk INNER JOIN tbl_chamada c ON id_aluno = id_aluno_fk WHERE tipo_usuario = 2 AND cpf = 47467670842";
        try {
            Connection con = getConnection();
            List<Chamada> presenca = new ArrayList<>();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                Chamada chamada = new Chamada();
                chamada.setNome_aluno(rs.getString("nome"));
                chamada.setData(rs.getDate("data"));
                //chamada.setHora_inicio(rs.getDate("hora_inicio"));
                //chamada.setHora_final(rs.getDate("hora_final"));
                presenca.add(chamada);
                return presenca;
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
}
