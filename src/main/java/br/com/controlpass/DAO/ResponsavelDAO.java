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
    private List<Chamada> chamadaFiltrada = new ArrayList<>();

    public List<Chamada> getPresencas(Usuario usuario) throws BusinessException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.rm_fk, a.nome_aluno,c.situacao, data, m.nm_materia,s.nm_curso  FROM tbl_chamada c INNER JOIN tbl_usuario u ON c.rm_fk = u.rm AND u.cpf = ? INNER JOIN tbl_materia m ON c.id_materia_fk = m.id_materia \n" +
"INNER JOIN tbl_curso s ON c.id_curso_fk = s.id_curso\n" +
"INNER JOIN tbl_aluno a ON c.rm_fk = a.rm";
        try {
            Connection con = getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getCpf());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Chamada chamada = new Chamada();
                chamada.setRm(rs.getInt("rm_fk"));
                chamada.setNome(rs.getString("nome_aluno"));
                chamada.setNome_materia(rs.getString("nm_materia"));
                chamada.setNome_curso(rs.getString("nm_curso"));
                chamada.setSituacao(rs.getString("situacao"));
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

    public List<Chamada> getChamadaFiltrada() {
        return chamadaFiltrada;
    }

    public void setChamadaFiltrada(List<Chamada> chamadaFiltrada) {
        this.chamadaFiltrada = chamadaFiltrada;
    }
    
    }
