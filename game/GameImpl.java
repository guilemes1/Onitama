package game;

import exception.IllegalMovementException;
import exception.IncorrectTurnOrderException;
import exception.InvalidCardException;
import exception.InvalidPieceException;

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

    }

    @Override
    public void takeMove() throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException {

    }
}
