package org.example;

/****************************
 Navio.java
 Descriçao: Classe com as caracteristicas dos navios usados no jogo.
 @author: Leonardo Silva

 Class fields:
 - nome: nome do navio
 - tamanho: tamanho do navio em número de compartimentos
 - simbolo: caracter usado para representar o navio quando tabuleiro é exibido no terminal
 - partes: vetor de compartimentos que formam o navio
 ******************************/
public class Navio {
    private String nome;
    private int tamanho;
    private char simbolo;
    private Compartimento[] partes;

    public Navio(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.simbolo = ' ';
        this.partes = new Compartimento[tamanho];
    }

    public Navio(int tamanho, char simbolo) {
        this.nome = "";
        this.tamanho = tamanho;
        this.simbolo = simbolo;
        this.partes = new Compartimento[tamanho];
    }

    public Navio() {
        this.nome = "";
        this.tamanho = 0;
        this.simbolo = ' ';
        this.partes = null;
    }

    public int getTamanho() {
        return this.tamanho;
    }
}