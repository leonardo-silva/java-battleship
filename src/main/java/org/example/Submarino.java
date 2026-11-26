package org.example;

/****************************
 Submarino.java
 Descriçao: Classe que representa um navio do tipo submarino.
 @author: Leonardo Silva
 ******************************/
public class Submarino extends Navio {
    public Submarino(String nome, int tamanho) {
        super(nome, tamanho);
    }

    public Submarino() {
        super();
    }

    public Submarino(int tamanho, char simbolo) {
        super(tamanho, simbolo);
    }
}
