package br.com.fiap.excecoes;

public class MissaoException extends Exception{

    public MissaoException(String mensagem) {
        super(mensagem);
    }

    public MissaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
