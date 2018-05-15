package br.com.controlpass.DAO;

import br.com.controlpass.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    private Connection connection;

    private int cpf;

    private String nome;

    private int tipoUsuario;

    private String email;

    private int status;

    private String login;

    private String senha;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public int getCPF(Usuario usuario)
    {
    	String sql = "SELECT u.cpf FROM Usuario u WHERE u.cpf=";
    	/*ResultSet rs;
    	return 1234;*/
    	//TODO retornar cpf com hibernate e returnar com o cpf
    	
    	
    	
    }
    
    public boolean adiciona(Usuario usuario) {
        Statement st = null;
        ResultSet rs = null;

        String sql = "INSERT INTO tbl_usario(cpf,nome,tipo_usuario, email, status, login, senha) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, usuario.getCpf());
            stmt.setString(2, usuario.getNome());
            stmt.setInt(3, usuario.getTipoUsuario());
            stmt.setString(4, usuario.getEmail());
            stmt.setInt(5, usuario.getStatus());
            stmt.setString(6, usuario.getLogin());
            stmt.setString(7, usuario.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return false;
    }

    public void closeConnection() throws SQLException {

        connection.close();
    }

}
