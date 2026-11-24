package org.example;

/****************************
 Jogador.java
 Descriçao: Classe que representa um jogador do jogo.
 @author: Leonardo Silva
 ****************************/
public class Jogador {
    private String nickname;
    private int score;
    private Tabuleiro tabuleiro;

    public Jogador(String nickname) {
        this.nickname = nickname;
        this.score = 0;
        this.tabuleiro = new Tabuleiro(Main.NLINHAS_TABULEIRO, Main.NCOLUNAS_TABULEIRO);
        this.tabuleiro.inicializa();
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getScore() {
        return this.score;
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }
}
