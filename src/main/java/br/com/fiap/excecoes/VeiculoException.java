package br.com.fiap.excecoes;

public class VeiculoException extends Exception {
    public VeiculoException(String mensagem) {
        super(mensagem);
    }

    public VeiculoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
