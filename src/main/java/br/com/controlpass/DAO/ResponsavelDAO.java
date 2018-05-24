package br.com.controlpass.DAO;



import br.com.controlpass.exception.BusinessException;
import br.com.controlpass.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ResponsavelDAO extends AbstractDAO {
	public String Base() throws SQLException{
		return Base();
	  }

	}

	class Child extends ResponsavelDAO{
	  public Child(){
	   //here it implicitly invokes `Base()`, So handle it here
		Connection con = new ConnectionFactory().getConnection();
		try {
			PreparedStatement smtm = con.prepareStatement("SELECT u.cpf FROM Usuario u WHERE u.cpf=");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	
	//Connection con = new ConnectionFactory().getConnection();
	//PreparedStatement smtm = con.prepareStatement("SELECT u.cpf FROM Usuario u WHERE u.cpf=");
          
          public void buscaCpf(Usuario usuario) throws BusinessException{
        PreparedStatement stmt = null;
        String sql = "SELECT cpf FROM tbl_usuario WHERE cpf = ?";
        
        try {
        Connection con = getConnection();
        stmt = con.prepareStatement(sql);
        stmt.setString(1, usuario.getCpf());
            
        } catch (Exception e) {
        }finally {
            closeStatement(stmt);
            closeConnection();
        }
        
        return;
    }
}
