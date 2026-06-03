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
}
