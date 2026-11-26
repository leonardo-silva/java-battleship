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

    private final static int HORIZONTAL = 0;
    private final static int VERTICAL = 1;

    public final static int NLINHAS_TABULEIRO = 10;
    public final static int NCOLUNAS_TABULEIRO = 10;

    public static Jogador jogador1;
    public static Jogador jogador2;

    static void main(String[] args) {
        try {
            inicializaJogo();
            Terminal.mostraTabuleiro(jogador1);
            Terminal.mostraTabuleiro(jogador2);
        } catch (NumberFormatException nfe) {
            System.err.println("Erro ao inicializar o jogo: " + nfe.getMessage());
        }
    }

    public static void inicializaJogo() {
        jogador1 = new Jogador("Eu");
        colocaNavioTabuleiro(new Contratorpedeiro(TAMANHO_CONTRATORPEDEIRO, 'C'), jogador1.getTabuleiro());
        colocaNavioTabuleiro(new PortaAviao(TAMANHO_PORTA_AVIAO, 'A'), jogador1.getTabuleiro());
        colocaNavioTabuleiro(new NavioTanque(TAMANHO_NAVIO_TANQUE, 'T'), jogador1.getTabuleiro());
        colocaNavioTabuleiro(new Submarino(TAMANHO_SUBMARINO, 'S'), jogador1.getTabuleiro());
        jogador2 = new Jogador("Computador");
        colocaNavioTabuleiro(new Contratorpedeiro(TAMANHO_CONTRATORPEDEIRO, 'C'), jogador2.getTabuleiro());
        colocaNavioTabuleiro(new PortaAviao(TAMANHO_PORTA_AVIAO, 'A'), jogador2.getTabuleiro());
        colocaNavioTabuleiro(new NavioTanque(TAMANHO_NAVIO_TANQUE, 'T'), jogador2.getTabuleiro());
        colocaNavioTabuleiro(new Submarino(TAMANHO_SUBMARINO, 'S'), jogador2.getTabuleiro());
    }

    /*
     * Objetivo: Distribuir o navio em uma posição do tabuleiro, de forma aleatória.
     * Descrição: Este método deve selecionar uma posição aleatória da matriz do tabuleiro para tentar inserir o navio
     *   passado como parâmetro. No caso de um tabuleiro 10x10, deve-se sortear uma posição entre 0 e 99 para
     *   ser a posição inicial do navio. Da esquerda para a direita na horizontal e de cima para baixo na vertical.
     *   A orientação, HORIZONTAL ou VERTICAL, também deve ser aleatória.
     * @params:
     *  - Navio navio: navio a ser incluído no tabuleiro
     *  - Tabuleiro tabuleiro: tabuleiro no qual o navio será incluído
     * TODO:
     *  - Colocar um timeout para não correr o risco de ficar preso indefinidamente sorteando posições inválidas. Gerar
     * uma exceção caso atinja o timeout.
     */
    public static void colocaNavioTabuleiro(Navio navio, Tabuleiro tabuleiro) {
        // Temos que selecionar linha (A--J), coluna (1--10) e orientação (H-V)
        Random random = new Random();
        int posicao, linha, coluna, orientacao;

        do {
            posicao = random.nextInt(NLINHAS_TABULEIRO * NCOLUNAS_TABULEIRO);
            linha = posicao / NCOLUNAS_TABULEIRO;
            coluna = posicao % NCOLUNAS_TABULEIRO;
            orientacao = random.nextInt(2);
        } while (! posicaoOkNavio(linha, coluna, orientacao, navio.getTamanho(), tabuleiro.getMatriz()));
        // Inclui submarino no tabuleiro
        incluiNavioTabuleiro(linha, coluna, orientacao, navio, tabuleiro.getMatriz());
    }

    public static void incluiNavioTabuleiro (int linha, int coluna,
                                             int orientacao, Navio navio, Compartimento[][] matriz) {
        if (orientacao == HORIZONTAL) {
            for(int j=coluna; j<(coluna+navio.getTamanho()); j++)
                matriz[linha][j] = new Compartimento(navio, (j-coluna));
        } else {
            for(int i=linha; i<(linha+navio.getTamanho()); i++)
                matriz[i][coluna] = new Compartimento(navio, (i-linha));
        }
    }

    /*
     * Verifica se a coordenada do tabuleiro pode receber um navio do tamanho informado.
     */
    public static boolean posicaoOkNavio(int linha, int coluna,
                                         int orientacao, int tamanhoNavio, Compartimento[][] matriz) {
        if (orientacao == HORIZONTAL) {
            if (coluna + tamanhoNavio > NCOLUNAS_TABULEIRO)
                return false;  // Vaza o tabuleiro na horizontal
            // Verifica se já não tem navio nas coordenadas desejadas
            for(int j=coluna; j<(coluna+tamanhoNavio); j++) {
                if (matriz[linha][j] != null)
                    return false;  // Já tem algum compartimento na coordenada selecionada
            }
        } else {  // VERTICAL
            if (linha + tamanhoNavio > NLINHAS_TABULEIRO)
                return false;  // Vaza o tabuleiro na vertical
            // Verifica se já não tem navio nas coordenadas desejadas
            for(int i=linha; i<(linha+tamanhoNavio); i++) {
                if (matriz[i][coluna] != null)
                    return false;  // Já tem algum compartimento na coordenada selecionada
            }
        }

        return true;
    }

}


