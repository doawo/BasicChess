package pieces;

import account.Player;
import board.Board;
import board.Box;
import game.GameController;
import game.Move;

public class Pawn extends Piece{
    private boolean _isFirstMove = true;

    public Pawn(boolean _white) {
        super(_white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box finish) {

        boolean result = false;
        int multiplier;

        if (isWhite())
            multiplier = 1;
        else
            multiplier = -1;

        if(_isFirstMove){
            this._isFirstMove = false;
            if((start.get_x() == finish.get_x() + multiplier * 2) && (start.get_y() == finish.get_y()) && (finish.get_piece() == null))
                result = true;
        }

        if(start.get_x() == finish.get_x() + multiplier && (start.get_y() == finish.get_y()) && (finish.get_piece() == null))
            result = true;

        if((finish.get_piece() != null) && (start.get_x() == finish.get_x()+multiplier) && ((start.get_y() == finish.get_y() + 1) || (start.get_y() == finish.get_y() -1)))
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
