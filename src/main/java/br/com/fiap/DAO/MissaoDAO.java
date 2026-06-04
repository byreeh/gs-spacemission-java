package br.com.fiap.DAO;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entity.Missao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MissaoDAO {
    private Connection conexao;

    public MissaoDAO() throws SQLException, ClassNotFoundException {
        ConexaoFactory factory = new ConexaoFactory();
        this.conexao = factory.conexao();
    }

    public void cadastrar(Missao missao) throws SQLException {
        String sql = "INSERT INTO T_MISSAO (ID, NOME, DESTINO, DATA_LANCAMENTO, STATUS, ORCAMENTO) " +
                "VALUES (SQ_MISSAO.NEXTVAL, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, missao.getNome());
        ps.setString(2, missao.getDestino());
        ps.setDate(3, Date.valueOf(missao.getDataLancamento()));
        ps.setString(4, missao.getStatus());
        ps.setDouble(5, missao.getOrcamento());
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }

    public List<Missao> listar() throws SQLException {
        List<Missao> missoes = new ArrayList<>();
        String sql = "SELECT * FROM T_MISSAO";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Missao missao = new Missao(
                    rs.getLong("ID"),
                    rs.getString("NOME"),
                    rs.getString("DESTINO"),
                    rs.getDate("DATA_LANCAMENTO").toLocalDate(),
                    rs.getString("STATUS"),
                    rs.getDouble("ORCAMENTO")
            );
            missoes.add(missao);
        }
        rs.close();
        ps.close();
        conexao.close();
        return missoes;
    }

    public Missao buscarPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM T_MISSAO WHERE ID = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Missao(
                    rs.getLong("ID"),
                    rs.getString("NOME"),
                    rs.getString("DESTINO"),
                    rs.getDate("DATA_LANCAMENTO").toLocalDate(),
                    rs.getString("STATUS"),
                    rs.getDouble("ORCAMENTO")
            );
        }
        rs.close();
        ps.close();
        conexao.close();
        return null;
    }

    public void atualizar(Missao missao) throws SQLException {
        String sql = "UPDATE T_MISSAO SET NOME=?, DESTINO=?, DATA_LANCAMENTO=?, STATUS=?, ORCAMENTO=? WHERE ID=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, missao.getNome());
        ps.setString(2, missao.getDestino());
        ps.setDate(3, Date.valueOf(missao.getDataLancamento()));
        ps.setString(4, missao.getStatus());
        ps.setDouble(5, missao.getOrcamento());
        ps.setLong(6, missao.getId());
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }

    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM T_MISSAO WHERE ID = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
        conexao.close();
    }
}
