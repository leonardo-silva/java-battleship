package org.example.ui;

import org.example.Compartimento;
import org.example.Jogador;
import org.example.Main;

public class Terminal {
    public static void mostraTabuleiro(Jogador jogador) {
        System.out.println("<<< BATALHA NAVAL >>>");
        System.out.println("Tabuleiro de " + jogador.getNickname() + ":");
        System.out.print("   ");
        for (int i = 0; i < Main.NCOLUNAS_TABULEIRO; i++) {
            System.out.print("  " + (i+1));
        }
        System.out.println();
        exibeLinhaMatriz(jogador.getTabuleiro().getMatriz());
    }

    private static void exibeLinhaMatriz(Compartimento[][] matriz) {
        char letra = 'A';
        for (Compartimento[] linha : matriz) {
            System.out.print("  " + letra + " ");

            for (Compartimento compartimento : linha) {
                if (compartimento != null) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" - ");
                }
            }
            letra++;
            System.out.println();
        }
    }
}
