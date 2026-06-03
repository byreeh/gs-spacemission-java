package br.com.fiap.BO;
import br.com.fiap.DAO.VeiculoDAO;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.excecoes.VeiculoException;

import java.sql.SQLException;
import java.util.List;

public class VeiculoBO {
    public void cadastrar(Veiculo veiculo) throws VeiculoException {
        try {
            if (veiculo.getNome() == null || veiculo.getNome().isEmpty()) {
                throw new VeiculoException("Nome do veículo é obrigatório");
            }

            if (veiculo.getCapacidade() <= 0) {
                throw new VeiculoException("Capacidade deve ser maior que zero");
            }

            if (veiculo.getTipo() == null || veiculo.getTipo().isEmpty()) {
                throw new VeiculoException("Tipo do veículo é obrigatório");
            }

            VeiculoDAO dao = new VeiculoDAO();
            dao.cadastrar(veiculo);

        } catch (SQLException | ClassNotFoundException e) {
            throw new VeiculoException("Erro ao cadastrar veículo", e);
        }
    }

    public List<Veiculo> listar() throws VeiculoException {
        try {
            VeiculoDAO dao = new VeiculoDAO();
            return dao.listar();
        } catch (Exception e) {
            throw new VeiculoException("Erro ao listar veículos", e);
        }
    }

    public Veiculo buscarPorId(Long id) throws VeiculoException {
        try {
            VeiculoDAO dao = new VeiculoDAO();
            Veiculo veiculo = dao.buscarPorId(id);

            if (veiculo == null) {
                throw new VeiculoException("Veículo não encontrado");
            }

            return veiculo;

        } catch (Exception e) {
            throw new VeiculoException("Erro ao buscar veículo", e);
        }
    }

    public void atualizar(Veiculo veiculo) throws VeiculoException {
        try {
            if (veiculo.getId() == null) {
                throw new VeiculoException("ID do veículo é obrigatório para atualização");
            }

            VeiculoDAO dao = new VeiculoDAO();
            dao.atualizar(veiculo);

        } catch (Exception e) {
            throw new VeiculoException("Erro ao atualizar veículo", e);
        }
    }

    public void deletar(Long id) throws VeiculoException {
        try {
            if (id == null) {
                throw new VeiculoException("ID é obrigatório para deletar");
            }

            VeiculoDAO dao = new VeiculoDAO();
            dao.deletar(id);

        } catch (Exception e) {
            throw new VeiculoException("Erro ao deletar veículo", e);
        }
    }
}
