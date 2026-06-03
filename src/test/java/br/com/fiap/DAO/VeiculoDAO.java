package br.com.fiap.DAO;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entity.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VeiculoDAO {

    private Connection conexao;

    public VeiculoDAO() throws SQLException, ClassNotFoundException {
        ConexaoFactory factory = new ConexaoFactory();
        this.conexao = factory.conexao();
    }

    public void cadastrar(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO T_VEICULO(ID, NOME, TIPO, CAPACIDADE, STATUS) " +
                "VALUES (SQ_VEICULO.NEXTVAL, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, veiculo.getNome());
        ps.setString(2, veiculo.getTipo());
        ps.setInt(3, veiculo.getCapacidade());
        ps.setString(4, veiculo.getStatus());
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }

    public List<Veiculo> listar() throws SQLException {
        List<Veiculo> veiculos  = new ArrayList<>();
        String sql = "SELECT * FROM T_VEICULO";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Veiculo v = new Veiculo(
                    rs.getLong("ID"),
                    rs.getString("NOME"),
                    rs.getString("TIPO"),
                    rs.getInt("CAPACIDADE"),
                    rs.getString("STATUS")
            );
            veiculos.add(v);
        }
        rs.close();
        ps.close();
        conexao.close();
        return veiculos;
    }

    public Veiculo buscarPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM T_VEICULO WHERE ID = ?";

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Veiculo(
                    rs.getLong("ID"),
                    rs.getString("NOME"),
                    rs.getString("TIPO"),
                    rs.getInt("CAPACIDADE"),
                    rs.getString("STATUS")
            );
        }
        rs.close();
        ps.close();
        conexao.close();
        return null;
    }

    public void atualizar(Veiculo veiculo) throws SQLException {
        String sql = "UPDATE T_VEICULO SET NOME=?, TIPO=?, CAPACIDADE=?, STATUS=? WHERE ID=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, veiculo.getNome());
        ps.setString(2, veiculo.getTipo());
        ps.setInt(3, veiculo.getCapacidade());
        ps.setString(4, veiculo.getStatus());
        ps.setLong(5, veiculo.getId());
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }

    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM T_VEICULO WHERE ID = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }
}
