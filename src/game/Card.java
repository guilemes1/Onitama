package src.game;

import java.util.*;

/**
 * Classe que contém informações das cartas
 */
public class Card {

    private String name;
    private Color color;
    private Position[] positions;
    /**
     * Construtor que define os principais atributos de uma cara
     * @param name Nome da carta
     * @param color Cor da carta
     * @param positions Todas as posições relativas de movimento
     */
    public Card(String name, Color color, Position[] positions) {
        this.name = name;
        this.color = color;
        this.positions = positions;
    }

    /**
     * Método que devolve o nome da carta
     * @return String que contém o nome da carta
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método que devolve a cor da carta
     * @return Enum src.game.Color que contém a cor da carta
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Método que devolve todas as possíveis posições relativas de movimento.
     * A posição atual da peça é o ponto de origem (0,0). Uma carta possui as possíveis posições de movimento em relação ao ponto de origem.
     * @return Um array de src.game.Position contendo todas as possíveis posições de movimento em relação ao ponto de origem
     */
    public Position[] getPositions() {
        return this.positions;
    }

    /**
     * Método que cria todas as cartas do jogo, embaralha-as e devolve as 5 que serão utilizadas na partida.
     * @return Vetor de cartas com todas as cartas do jogo
     */
    public static Card[] createCards() {
        Card[] todasCartas = {
                new Card("Tiger", Color.BLUE, new Position[] { new Position(-2, 0), new Position(+1, 0) }),
                new Card("Dragon", Color.RED, new Position[] { new Position(+1, -1), new Position(-1, -2), new Position(+1, +1), new Position(-1, +2) }),
                new Card("Frog", Color.RED, new Position[] { new Position(-1, -1), new Position(0, -2), new Position(+1, +1) }),
                new Card("Rabbit", Color.BLUE, new Position[] { new Position(+1, -1), new Position(-1, +1), new Position(0, +2) }),
                new Card("Crab", Color.BLUE, new Position[] { new Position(-1, 0), new Position(0, -2), new Position(0, +2) }),
                new Card("Elephant", Color.RED, new Position[] { new Position(0, -1), new Position(-1, -1), new Position(0, +1), new Position(-1, +1) }),
                new Card("Goose", Color.BLUE, new Position[] { new Position(0, -1), new Position(-1, -1), new Position(0, +1), new Position(+1, +1) }),
                new Card("Rooster", Color.RED, new Position[] { new Position(+1, -1), new Position(0, -1), new Position(0, +1), new Position(-1, +1) })
        };

        List<Card> cartasEmbaralhadas = new ArrayList<>(Arrays.asList(todasCartas));
        Collections.shuffle(cartasEmbaralhadas);

        return cartasEmbaralhadas.subList(0, 5).toArray(new Card[0]);
    }

    /**
     * Método imprime todos os movimentos possiveis de uma carta a partir do centro
     * do tabuleiro
     */
    public void printMoviments() {
        String amarelo = "\u001B[33m";
        String roxo = "\u001B[35m";
        String reset = "\u001B[0m";

        System.out.println("Selecione qual movimento deseja fazer, partindo do " + roxo + "roxo" + reset + " e indo para o " + amarelo + "amarelo" + reset);

        Position[] posicoes = this.getPositions();
        for (int i = 0; i < posicoes.length; i++) {
            System.out.println("Movimento " + (i + 1) + ":");
            System.out.println("  0 1 2 3 4");
            for (int j = 0; j < 5; j++) {
                System.out.print(j + " ");
                for (int k = 0; k < 5; k++) {
                    if (j == 2 && k == 2) {
                        System.out.print(roxo + "\u25A0 " + reset);
                    } else if (j == 2 + posicoes[i].getRow() && k == 2 + posicoes[i].getCol()) {
                        System.out.print(amarelo + "\u25A0 " + reset);
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
