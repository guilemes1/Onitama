package game;

import exception.IllegalMovementException;
import exception.IncorrectTurnOrderException;
import exception.InvalidCardException;
import exception.InvalidPieceException;

import java.util.Scanner;

public class GameImpl implements Game{

    private Spot[][] board;
    private Card tableCard;
    private Player redPlayer;
    private Player bluePlayer;
    private Player currentPlayer;

    public GameImpl(Player redPlayer, Player bluePlayer) {
        this.board = new Spot[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {               //caso a linha seja 0 é azul
                    if (j == 2) {           //caso a posição seja a do meio é mestre
                        this.board[i][j] = new Spot(new Piece(Color.BLUE, true), new Position(i, j), Color.BLUE);
                    } else {
                        this.board[i][j] = new Spot(new Piece(Color.BLUE, false), new Position(i, j), Color.BLUE);
                    }
                } else if (i == 4) {        //caso a linha seja 4 é vermelho
                    if (j == 2) {
                        this.board[i][j] = new Spot(new Piece(Color.RED, true), new Position(i, j), Color.RED);
                    } else {
                        this.board[i][j] = new Spot(new Piece(Color.RED, false), new Position(i, j), Color.RED);
                    }
                } else {   //Senão marcar como none
                    this.board[i][j] = new Spot(new Position(i, j));
                }
            }
        }
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
    }

    @Override
    public Color getSpotColor(Position position) {
        return this.board[position.getRow()][position.getCol()].getColor();
    }

    @Override
    public Piece getPiece(Position position) {
        return this.board[position.getRow()][position.getCol()].getPiece();
    }

    @Override
    public Card getTableCard() {
        return this.tableCard;
    }

    @Override
    public void setTableCard(Card tableCard) {
        this.tableCard = tableCard;
    }

    @Override
    public Player getRedPlayer() {
        return this.redPlayer;
    }

    @Override
    public Player getBluePlayer() {
        return this.bluePlayer;
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void makeMove(Piece piece, Card card, Position position) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException {

    }

    @Override
    public boolean checkVictory(Color color) {
        return false;
    }

    @Override
    public void printBoard() {
        String vermelho = "\u001B[31m";
        String azul = "\u001B[34m";
        String reset = "\u001B[0m";

        System.out.println("  0 1 2 3 4");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 5; j++) {
                // Atribuição de valor - ou M ou A depende da peça que esta na posição
                String imprimir = board[i][j].getPiece() == null ? "-" : board[i][j].getPiece().isAlive() ? board[i][j].getPiece().isMaster() ? "M" : "A" : "-";
                // Impressão da cor do jogador
                if (this.board[i][j].getColor().equals(Color.RED)) {
                    System.out.print(vermelho + imprimir + " " + reset);
                } else if (this.board[i][j].getColor().equals(Color.BLUE)) {
                    System.out.print(azul + imprimir + " " + reset);
                } else  {  //Padrão para caso não haja peça
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void takeMove() throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException {
        String vermelho = "\u001B[31m";
        String azul = "\u001B[34m";
        String reset = "\u001B[0m";

        Scanner scan = new Scanner(System.in);

        String corJogadorAtual = currentPlayer.getPieceColor().toString().equals("BLUE") ? azul : vermelho;

        // Imprime uma mensagem ao jogador, infomando de quem    é a vez e a cor
        System.out.println("Vez do " + this.currentPlayer.getName() + " com a cor " + corJogadorAtual + this.currentPlayer.getPieceColor().toString() + reset);

        // Lê as cartas da mão do jogador
        Card[] cartas = this.currentPlayer.getCards();
        System.out.println("Suas cartas: " + cartas[0].getName() + " e " + cartas[1].getName());

        // Pede ao jogador para que ele confirme de quem é a vez
        System.out.print("Confirme a cor do jogador que fara a jogada (" + vermelho + "RED" + reset + " ou " + azul + "BLUE" + reset + "): ");
        String corSelecionada = scan.nextLine();

        // Caso a cor digitada seja diferente do jogador atual lança uma exceção
        if (!currentPlayer.getPieceColor().toString().equals(corSelecionada)) {
            throw new IncorrectTurnOrderException("A cor selecionada não corresponde ao jogador atual");
        }

        // Imprime o tabuleiro
        this.printBoard();

        System.out.println("Digite a posição da peça que deseja mover: ");
        System.out.print("Linha (valor inteiro entre 0 a 4): ");
        int linha = Integer.parseInt(scan.nextLine());
        System.out.print("Coluna (valor inteiro entre 0 e 4): ");
        int coluna = Integer.parseInt(scan.nextLine());

        // Caso a posição da peça digitida seja vazia lança uma exceção
        if (board[linha][coluna].getPiece() == null) {
            throw new InvalidPieceException("A peça não existe");
        }

        // Caso a posição da peça digitada não seja da cor do jogador lança uma exceção
        if (!board[linha][coluna].getColor().toString().equals(corSelecionada)) {
            throw new InvalidPieceException("A peça selecionada não pertence a sua cor ou não é válida");
        }

        System.out.print("\nDigite a carta que deseja utilizar: ");
        String cartaSelecionada = scan.nextLine();
        System.out.println();

        if (!cartas[0].getName().equals(cartaSelecionada) && !cartas[1].getName().equals(cartaSelecionada)) {
            throw new InvalidCardException("A carta selecionada não esta na mão do jogador atual");
        }

        int aux = cartas[0].getName().equals(cartaSelecionada) ? 1 : 0;
        cartas[aux].printMoviments();
    }
}
