package pieces;

import account.Player;
import board.Board;
import board.Box;
import game.Move;

public class Bishop extends Piece{

    public Bishop(boolean _white) {
        super(_white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box finish) {
        boolean result = false;

        int multiplier = Math.abs(start.get_x() - finish.get_x());

        if(((start.get_x() == finish.get_x() + multiplier && start.get_y() == finish.get_y() - multiplier) || (start.get_x() == finish.get_x() - multiplier && start.get_y() == finish.get_y() + multiplier)) && !piecesOnWay(board, start, finish))
            result = true;

        if(((start.get_x() == finish.get_x() - multiplier && start.get_y() == finish.get_y() - multiplier) || (start.get_x() == finish.get_x() + multiplier && start.get_y() == finish.get_y() + multiplier)) && !piecesOnWay(board, start, finish))
            result = true;

        return result;
    }

    @Override
    public void updateDangerBoxes(Board board, Move move, Player currentPlayer) {

    }

    @Override
    public boolean piecesOnWay(Board board, Box start, Box finish) {
        int multiplier = Math.abs(start.get_x() - finish.get_x());

        for(int i=1; i < multiplier; i++){
            if(start.get_x() > finish.get_x() && start.get_y() > finish.get_y()) {//left top
                if (board.getBox(start.get_x() - i, start.get_y() - i).get_piece() != null)
                    return true;
            } else if(start.get_x() < finish.get_x() && start.get_y() < finish.get_y()) {//right bottom
                if (board.getBox(start.get_x() + i, start.get_y() + i).get_piece() != null)
                    return true;
            }

            if(start.get_x() < finish.get_x() && start.get_y() > finish.get_y()) {//left bottom
                if (board.getBox(start.get_x() + i, start.get_y() - i).get_piece() != null)
                    return true;
            }else if(start.get_x() > finish.get_x() && start.get_y() < finish.get_y()) {//right top
                if (board.getBox(start.get_x() - i, start.get_y() + i).get_piece() != null)
                    return true;
            }
        }

        return false;
    }
}
