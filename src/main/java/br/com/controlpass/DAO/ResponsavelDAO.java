package br.com.controlpass.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ResponsavelDAO {
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
}
