package br.com.fiap.entity;

import java.time.LocalDate;

public class Missao {

    private Long id;
    private String nome;
    private String destino;
    private LocalDate dataLancamento;
    private String status;
    private Double orcamento;

    public Missao() {}

    public Missao(Long id, String nome, String destino, LocalDate dataLancamento, String status, Double orcamento) {
        this.id = id;
        this.nome = nome;
        this.destino = destino;
        this.dataLancamento = dataLancamento;
        this.status = status;
        this.orcamento = orcamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public String toString() {
        return "\n\nMissao" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nDestino: " + destino +
                "\nData de Lancamento: " + dataLancamento +
                "\nStatus: " + status +
                "\nOrcamento: " + orcamento;
    }
}
