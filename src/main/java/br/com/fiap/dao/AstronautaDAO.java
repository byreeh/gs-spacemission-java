package br.com.fiap.DAO;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entity.Astronauta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AstronautaDAO {

    private Connection conexao;

    public AstronautaDAO() throws SQLException, ClassNotFoundException {
        ConexaoFactory factory = new ConexaoFactory();
        this.conexao = factory.conexao();
    }

    public void cadastrar(Astronauta astronauta) throws SQLException {
        String sql = "INSERT INTO T_ASTRONAUTA (ID, NOME, NACIONALIDADE, ESPECIALIDADE, STATUS) " +
                "VALUES (SQ_ASTRONAUTA.NEXTVAL, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, astronauta.getNome());
        ps.setString(2, astronauta.getNacionalidade());
        ps.setString(3, astronauta.getEspecialidade());
        ps.setString(4, astronauta.getStatus());
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }

    public List<Astronauta> listar() throws SQLException {
        List<Astronauta> astronautas = new ArrayList<>();
        String sql = "SELECT * FROM T_ASTRONAUTA";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Astronauta astronauta = new Astronauta(
                    rs.getLong("ID"),
                    rs.getString("NOME"),
                    rs.getString("NACIONALIDADE"),
                    rs.getString("ESPECIALIDADE"),
                    rs.getString("STATUS")
            );
            astronautas.add(astronauta);
        }
        rs.close();
        ps.close();
        conexao.close();
        return astronautas;
    }

    public Astronauta buscarPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM T_ASTRONAUTA WHERE ID = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Astronauta(
                    rs.getLong("ID"),
                    rs.getString("NOME"),
                    rs.getString("NACIONALIDADE"),
                    rs.getString("ESPECIALIDADE"),
                    rs.getString("STATUS")
            );
        }
        rs.close();
        ps.close();
        conexao.close();
        return null;
    }

    public void atualizar(Astronauta astronauta) throws SQLException {
        String sql = "UPDATE T_ASTRONAUTA SET NOME=?, NACIONALIDADE=?, ESPECIALIDADE=?, STATUS=? WHERE ID=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, astronauta.getNome());
        ps.setString(2, astronauta.getNacionalidade());
        ps.setString(3, astronauta.getEspecialidade());
        ps.setString(4, astronauta.getStatus());
        ps.setLong(5, astronauta.getId());
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }

    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM T_ASTRONAUTA WHERE ID = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }

}
