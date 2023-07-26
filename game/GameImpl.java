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
