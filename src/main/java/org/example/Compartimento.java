package org.example;

/****************************
 CompartimentoNavio.java
 Descriçao: Classe que representa uma das partes de um navio.
 @author: Leonardo Silva
 ******************************/
public class Compartimento {
    private Navio navio;
    private int id;

    public Compartimento(Navio nv, int id) {
        this.navio = nv;
        this.id = id;
    }

    public Navio getNavio() {
        return this.navio;
    }

    public int getId() {
        return this.id;
    }
}