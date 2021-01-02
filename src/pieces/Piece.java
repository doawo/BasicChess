package pieces;

import account.Player;
import board.Board;
import board.Box;
import game.Move;

public abstract class Piece {
    private boolean _killed = false, _white = false;

    public Piece(boolean _white) {
        this._white = _white;
    }

    public boolean isWhite() {
        return this._white;
    }

    public boolean isKilled(){
        return this._killed;
    }

    public abstract boolean canMove(Board board, Box start, Box finish);

    public abstract void updateDangerBoxes(Board board, Move move, Player currentPlayer);

    public abstract boolean piecesOnWay(Board board, Box start, Box finish);

    public void set_killed(boolean _killed) {
        this._killed = _killed;
    }

    public void set_white(boolean _white) {
        this._white = _white;
    }
}
