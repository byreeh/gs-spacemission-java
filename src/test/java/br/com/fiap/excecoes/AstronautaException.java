package br.com.fiap.excecoes;

public class AstronautaException extends Exception {
    public AstronautaException(String mensagem) {
        super(mensagem);
    }

    public AstronautaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
