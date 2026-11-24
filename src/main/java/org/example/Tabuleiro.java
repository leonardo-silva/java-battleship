package org.example;

/****************************
 Tabuleiro.java
 Descriçao: Classe que representa o tabuleiro do jogo.
 @author: Leonardo Silva
 ****************************/
public class Tabuleiro {
    private int nLinhas;
    private int nColunas;
    private Compartimento[][] matriz;

    public Tabuleiro(int nLinhas, int nColunas) {
        this.nLinhas = nLinhas;
        this.nColunas = nColunas;
        this.matriz = new Compartimento[nLinhas][nColunas];
    }

    public void inicializa() {
        for (int i = 0; i < nLinhas; i++) {
            for (int j = 0; j < nColunas; j++) {
                matriz[i][j] = null;
            }
        }
    }

    public Compartimento[][] getMatriz() {
        return this.matriz;
    }
}
