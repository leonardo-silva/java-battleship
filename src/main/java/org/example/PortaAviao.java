package org.example;

/****************************
 PortaAviao.java
 Descriçao: Classe que representa um navio do tipo porta-aviões.
 @author: Leonardo Silva
 ******************************/
public class PortaAviao extends Navio {
    public PortaAviao(String nome, int tamanho) {
        super(nome, tamanho);
    }

    public PortaAviao() {
        super();
    }

    public PortaAviao(int tamanho, char simbolo) {
        super(tamanho, simbolo);
    }
}
