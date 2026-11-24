package org.example;

/****************************
 Navio.java
 Descriçao: Classe com as caracteristicas dos navios usados no jogo.
 @author: Leonardo Silva
 ******************************/
public class Navio {
    private String nome;
    private int tamanho;
    private Compartimento[] partes;

    public Navio(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.partes = new Compartimento[tamanho];
    }

    public Navio() {
        this.nome = "";
        this.tamanho = 0;
        this.partes = null;
    }

    public int getTamanho() {
        return this.tamanho;
    }
}