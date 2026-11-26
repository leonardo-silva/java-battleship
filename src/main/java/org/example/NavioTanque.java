package org.example;

/****************************
 NavioTanque.java
 Descriçao: Classe que representa um navio do tipo navio-tanque.
 @author: Leonardo Silva
 ******************************/
public class NavioTanque extends Navio {
    public NavioTanque(String nome, int tamanho) {
        super(nome, tamanho);
    }

    public NavioTanque() {
        super();
    }

    public NavioTanque(int tamanho, char simbolo) {
        super(tamanho, simbolo);
    }
}
