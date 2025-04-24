package com.example.poketrainer.model;

public class Pokemon {

    private int id;
    private String nome;
    private String tipo;
    private int nivel;
    private int treinadorId;  

    public Pokemon() {
        this.id = 0;
        this.nome = "";
        this.tipo = "";
        this.nivel = 1;  // Nível padrão
        this.treinadorId = 0;
    }

    public Pokemon(int id, String nome, String tipo, int nivel, int treinadorId) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.treinadorId = treinadorId;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getTreinadorId() {
        return treinadorId;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setTreinadorId(int treinadorId) {
        this.treinadorId = treinadorId;
    }

    public void aumentarNivel() {
        this.nivel++;
    }

    public String exibirInformacoes() {
        return "Pokémon: " + nome + "\nTipo: " + tipo + "\nNível: " + nivel + "\nTreinador ID: " + treinadorId;
    }
}
