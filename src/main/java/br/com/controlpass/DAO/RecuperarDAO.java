package br.com.controlpass.DAO;

import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecuperarDAO extends AbstractDAO{
    public void reset(Usuario usuario) throws BusinessException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "CALL reset_senha(?)";

        try {
            Connection con = getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getCpf());
            rs = stmt.executeQuery();
            stmt.execute();

        } catch (SQLException u) {
            
            throw new RuntimeException(u);
        } finally {
            closeStatement(stmt);
            closeResultSet(rs);
            closeConnection();
        }

    }
}
