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

    public List<Chamada> getPresenca(){
            PreparedStatement stmt = null;
            ResultSet rs = null;
        try {
            Connection con = getConnection();
            List<Chamada> presenca = new ArrayList<>();
            String sql = "SELECT id_aluno a, nome u, data c, hora_inicio c, hora_final c \n"
                    + "FROM tbl_aluno a \n"
                    + "INNER JOIN tbl_usuario u ON u.id_usuario = a.id_usuario_fk\n"
                    + "INNER JOIN tbl_chamada c ON id_aluno = id_aluno_fk \n"
                    + "WHERE tipo_usuario = 2 AND cpf = 47467670842;";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Chamada chamada = new Chamada();
                chamada.setNome(rs.getString("nome"));
                //chamada.setDataInicio(rs.getDate("data"));
                //chamada.getHoraInicio(rs.getTime("hora_inicio"));
                //chamada.getHoraFinal(rs.getTime("hora_final"));
                presenca.add(chamada);
            }
            return presenca;
        } catch (SQLException e) {            
            return null;
        } finally {
            closeStatement(stmt);
            closeResultSet(rs);
            closeConnection();
        }
}
}
