package br.com.fiap.entity;

public class Veiculo {

    private Long id;
    private String nome;
    private String tipo;
    private Integer capacidade;
    private String status;

    public Veiculo() {}

    public Veiculo(Long id, String nome, String tipo, Integer capacidade, String status) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.status = status;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n\nVeiculo" +
                "\nID:" + id +
                "\nNome: " + nome +
                "\nTipo: " + tipo +
                "\nCapacidade: " + capacidade +
                "\nStatus: " + status;
    }
}
