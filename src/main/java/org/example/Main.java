package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/******************************************************************************
 Main.java

 Classe Principal do jogo Batalha Naval.

 @author Leonardo Silva

 Link com regras principais do jogo:
 https://pt.wikipedia.org/wiki/Batalha_naval_(jogo)

 Os tipos básicos de navios são: porta-aviões (cinco quadrados),
 navios-tanque (quatro quadrados),
 contratorpedeiros (três quadrados) e submarinos (dois quadrados).
 Vale notar que os quadrados que compõem um navio devem estar conectados e em fila reta.
 *******************************************************************************/
import org.example.ui.Terminal;

import java.util.Random;

public class Main
{
    private final static int TAMANHO_PORTA_AVIAO = 5;
    private final static int TAMANHO_NAVIO_TANQUE = 4;
    private final static int TAMANHO_CONTRATORPEDEIRO = 3;
    private final static int TAMANHO_SUBMARINO = 2;

    public final static int NLINHAS_TABULEIRO = 10;
    public final static int NCOLUNAS_TABULEIRO = 10;

    public static Jogador jogador1;
    public static Jogador jogador2;

    static void main(String[] args) {
        try {
            inicializaJogo();
            Terminal.mostraTabuleiro(jogador1);
        } catch (NumberFormatException nfe) {
            System.err.println("Erro ao inicializar o jogo: " + nfe.getMessage());
        }
    }

    public static void inicializaJogo() {
        jogador1 = new Jogador("Eu");
        jogador2 = new Jogador("Computador");
    }
}


