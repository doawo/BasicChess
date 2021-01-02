package pieces;

import account.Player;
import board.Board;
import board.Box;
import game.Move;

public class NKnight extends Piece{

    public NKnight(boolean _white) {
        super(_white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box finish) {
        boolean result = false;

        if(Math.abs(finish.get_x() - start.get_x()) == 2 && Math.abs(finish.get_y() - start.get_y()) == 1)
            result = true;

        if(Math.abs(finish.get_x() - start.get_x()) == 1 && Math.abs(finish.get_y() - start.get_y()) == 2)
            result = true;

        return result;
    }

    @Override
    public void updateDangerBoxes(Board board, Move move, Player currentPlayer) {

    }

    @Override
    public boolean piecesOnWay(Board board, Box start, Box finish) {
        return false;
    }
}
