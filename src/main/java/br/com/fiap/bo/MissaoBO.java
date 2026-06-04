package br.com.fiap.BO;
import br.com.fiap.DAO.MissaoDAO;
import br.com.fiap.entity.Missao;
import br.com.fiap.excecoes.MissaoException;

import java.sql.SQLException;
import java.util.List;

public class MissaoBO {
    public void cadastrar(Missao missao) throws MissaoException {
        try {
            if (missao.getNome() == null || missao.getNome().isEmpty()) {
                throw new MissaoException("Nome da missão é obrigatório");
            }

            if (missao.getOrcamento() <= 0) {
                throw new MissaoException("Orçamento deve ser maior que zero");
            }

            MissaoDAO dao = new MissaoDAO();
            dao.cadastrar(missao);

        } catch (SQLException | ClassNotFoundException e) {
            throw new MissaoException("Erro ao cadastrar missão", e);
        }
    }

    public List<Missao> listar() throws MissaoException {
        try {
            MissaoDAO dao = new MissaoDAO();
            return dao.listar();
        } catch (Exception e) {
            throw new MissaoException("Erro ao listar missões", e);
        }
    }

    public Missao buscarPorId(Long id) throws MissaoException {
        try {
            MissaoDAO dao = new MissaoDAO();
            Missao missao = dao.buscarPorId(id);
            if (missao == null) {
                throw new MissaoException("Missão não encontrada");
            }
            return missao;
        } catch (Exception e) {
            throw new MissaoException("Erro ao buscar missão", e);
        }
    }

    public void atualizar(Missao missao) throws MissaoException {
        try {
            if (missao.getId() == null) {
                throw new MissaoException("ID da missão é obrigatório para atualização");
            }
            MissaoDAO dao = new MissaoDAO();
            dao.atualizar(missao);
        } catch (Exception e) {
            throw new MissaoException("Erro ao atualizar missão", e);
        }
    }

    public void deletar(Long id) throws MissaoException {
        try {
            if (id == null) {
                throw new MissaoException("ID é obrigatório para deletar");
            }
            MissaoDAO dao = new MissaoDAO();
            dao.deletar(id);
        } catch (Exception e) {
            throw new MissaoException("Erro ao deletar missão", e);
        }
    }
}
