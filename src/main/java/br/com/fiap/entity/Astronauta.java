package br.com.fiap.entity;

public class Astronauta {

    private Long id;
    private String nome;
    private String nacionalidade;
    private String especialidade;
    private String status;

    public  Astronauta() {
    }

    public Astronauta(Long id, String nome, String nacionalidade, String especialidade, String status) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.especialidade = especialidade;
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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nAstronauta{" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nNacionalidade: " + nacionalidade +
                "\nEspecialidade: " + especialidade +
                "\nStatus: " + status;
    }
}
