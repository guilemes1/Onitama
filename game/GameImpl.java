package game;

import exception.IllegalMovementException;
import exception.IncorrectTurnOrderException;
import exception.InvalidCardException;
import exception.InvalidPieceException;

public class GameImpl implements Game{
    @Override
    public Color getSpotColor(Position position) {
        return null;
    }

    @Override
    public Piece getPiece(Position position) {
        return null;
    }

    @Override
    public Card getTableCard() {
        return null;
    }

    @Override
    public void setTableCard(Card tableCard) {

    }

    @Override
    public Player getRedPlayer() {
        return null;
    }

    @Override
    public Player getBluePlayer() {
        return null;
    }

    @Override
    public Player getCurrentPlayer() {
        return null;
    }

    @Override
    public void setCurrentPlayer(Player currentPlayer) {

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
