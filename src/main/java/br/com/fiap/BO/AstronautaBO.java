package br.com.fiap.BO;

import br.com.fiap.DAO.AstronautaDAO;
import br.com.fiap.entity.Astronauta;
import br.com.fiap.excecoes.AstronautaException;

import java.sql.SQLException;
import java.util.List;

public class AstronautaBO {
    public void cadastrar(Astronauta astronauta) throws AstronautaException {
        try {
            if (astronauta.getNome() == null || astronauta.getNome().isEmpty()) {
                throw new AstronautaException("Nome do astronauta  é obrigatório");
            }

            if (astronauta.getNacionalidade() == null || astronauta.getNacionalidade().isEmpty()) {
                throw new AstronautaException("Nacionalidade é obrigatória");
            }

            if (astronauta.getEspecialidade() == null || astronauta.getEspecialidade().isEmpty()) {
                throw new AstronautaException("Especialidade é obrigatória");
            }

            AstronautaDAO dao = new AstronautaDAO();
            dao.cadastrar(astronauta);

        } catch (SQLException | ClassNotFoundException e) {
            throw new AstronautaException("Erro ao cadastrar astronauta", e);
        }
    }

    public List<Astronauta> listar() throws AstronautaException {
        try {
            AstronautaDAO dao = new AstronautaDAO();
            return dao.listar();
        } catch (Exception e) {
            throw new AstronautaException("Erro ao listar astronautas", e);
        }
    }

    public Astronauta buscarPorId(Long id) throws AstronautaException {
        try {
            AstronautaDAO dao = new AstronautaDAO();
            Astronauta astronauta = dao.buscarPorId(id);
            if (astronauta == null) {
                throw new AstronautaException("Astronauta não encontrado");
            }
            return astronauta;
        } catch (Exception e) {
            throw new AstronautaException("Erro ao buscar astronauta", e);
        }
    }

    public void atualizar(Astronauta astronauta) throws AstronautaException {
        try {
            if (astronauta.getId() == null) {
                throw new AstronautaException("ID do astronauta é obrigatório para atualização");
            }
            AstronautaDAO dao = new AstronautaDAO();
            dao.atualizar(astronauta);
        } catch (Exception e) {
            throw new AstronautaException("Erro ao atualizar astronauta", e);
        }
    }

    public void deletar(Long id) throws AstronautaException {
        try {
            if (id == null) {
                throw new AstronautaException("ID é obrigatório para deletar");
            }
            AstronautaDAO dao = new AstronautaDAO();
            dao.deletar(id);
        } catch (Exception e) {
            throw new AstronautaException("Erro ao deletar astronauta", e);
        }
    }
}
