package pieces;

import account.Player;
import board.Board;
import board.Box;
import game.Move;

public class Queen extends Piece{
    public Queen(boolean _white) {
        super(_white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box finish) {
        boolean result = false;

        if((start.get_x() == finish.get_x()) || (start.get_y() == finish.get_y())  && !piecesOnWay(board, start, finish))
            result = true;

        if((start.get_x() == finish.get_x() + 1) || (start.get_x() == finish.get_x() - 1))
            result = true;
        if((start.get_y() == finish.get_y() + 1) || (start.get_y() == finish.get_y() - 1))
            result = true;

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
        int usable;
        int x = Math.abs(start.get_x() - finish.get_x());
        int y = Math.abs(start.get_y() - finish.get_y());

        if (x == 0)
            usable = y;
        else
            usable = x;

        //a problem somewhere here, to fix

        for(int i =1; i < usable; i++) {
            if (x == 0) {
                if (start.get_y() > finish.get_y()) {//left
                    if (board.getBox(start.get_x(), start.get_y() - i).get_piece() != null)
                        return true;
                } else//right
                    if (board.getBox(start.get_x(), start.get_y() + i).get_piece() != null)
                        return true;
            } else {
                if (start.get_x() > finish.get_x()) {//up
                    if (board.getBox(start.get_x() - i, start.get_y()).get_piece() != null)
                        return true;
                } else//down
                    if (board.getBox(start.get_x() + i, start.get_y()).get_piece() != null)
                        return true;
            }

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
