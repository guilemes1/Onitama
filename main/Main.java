package main;

import exception.OnitamaGameException;
import game.Card;
import game.Color;
import game.GameImpl;
import game.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        Scanner scan = new Scanner(System.in);

        Card[] cards = Card.createCards();

        System.out.print("Digite o nome do jogador vermelho: ");
        String nomeJogadorVermelho = scan.nextLine();

        System.out.print("Digite o nome do jogador azul: ");
        String nomeJogadorAzul = scan.nextLine();

        // como as cartas foram esbaralhadas por createCards() as cartas
        // nas mãos dos jogadores e na mesa são colocadas em ordem do vetor
        Player jogadorVermelho = new Player(nomeJogadorVermelho, Color.RED, cards[0], cards[1]);
        Player jogadorAzul = new Player(nomeJogadorAzul, Color.BLUE, cards[2], cards[3]);

        GameImpl game = new GameImpl(jogadorVermelho, jogadorAzul);
        game.setTableCard(cards[4]);

        // define o jogador atual com base na cor da carta da mesa
        game.setCurrentPlayer(game.getTableCard().getColor() == Color.BLUE ? jogadorAzul : jogadorVermelho);

        System.out.println("A carta na mesa é " + game.getTableCard().getName() + "\n");

        boolean azulGanhou = game.checkVictory(Color.BLUE);
        boolean vermelhoGanhou = game.checkVictory(Color.RED);

        while (!azulGanhou && !vermelhoGanhou) {
            try {
                game.takeMove();
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro entre 0 e 4\n");
            } catch (OnitamaGameException e) {
                System.out.println(vermelho + e.getMessage() + reset + "\n");
            }

            game.printBoard();
            azulGanhou = game.checkVictory(Color.BLUE);
            vermelhoGanhou = game.checkVictory(Color.RED);
        }

        if (azulGanhou) {
            System.out.println("Parabéns " + jogadorAzul.getName() + ", Você ganhou a partida!");
        } else {
            System.out.println("Parabéns " + jogadorVermelho.getName() + ", você ganhou a partida!");
        }
        imprimeMensagemVencedor();

    }

    private static void imprimeMensagemVencedor() {
        System.out.println("       ___________      ");
        System.out.println("      '._==_==_=_.'     ");
        System.out.println("      .-\\:      /-.    ");
        System.out.println("     | (|:.     |) |    ");
        System.out.println("      '-|:.     |-'     ");
        System.out.println("        \\::.    /      ");
        System.out.println("         '::. .'        ");
        System.out.println("           ) (          ");
        System.out.println("         _.' '._        ");
        System.out.println("        '-------'       ");
    }
}
