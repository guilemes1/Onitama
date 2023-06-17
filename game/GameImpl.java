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
    public Player getRedPlayer() {
        return null;
    }

    @Override
    public Player getBluePlayer() {
        return null;
    }

    @Override
    public void makeMove(Card card, Position cardMove, Position currentPos) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException {

    }

    @Override
    public boolean checkVictory(Color color) {
        return false;
    }

    @Override
    public void printBoard() {

    }
}
