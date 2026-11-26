package org.example;

/****************************
 Contratorpedeiro.java
 Descriçao: Classe que representa um navio do tipo Contratorpedeiro.
 @author: Leonardo Silva
 ******************************/
public class Contratorpedeiro extends Navio {
    public Contratorpedeiro(String nome, int tamanho) {
        super(nome, tamanho);
    }

    public Contratorpedeiro() {
        super();
    }

    public Contratorpedeiro(int tamanho, char simbolo) {
        super(tamanho, simbolo);
    }
}
