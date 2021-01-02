package pieces;

import account.Player;
import board.Board;
import board.Box;
import game.Move;

public class Rook extends Piece{

    public Rook(boolean _white) {
        super(_white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box finish) {
        boolean result = false;

        if((start.get_x() == finish.get_x()) || (start.get_y() == finish.get_y()) && !piecesOnWay(board, start, finish))
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

        for(int i =1; i < usable; i++){
            if (x == 0) {
                if(start.get_y() > finish.get_y()) {//left
                    if (board.getBox(start.get_x(), start.get_y() - i).get_piece() != null)
                        return true;
                }else//right
                    if(board.getBox(start.get_x(), start.get_y() + i).get_piece() != null)
                        return true;
            } else {
                if(start.get_x() > finish.get_x()) {//up
                    if (board.getBox(start.get_x() - i, start.get_y()).get_piece() != null)
                        return true;
                }else//down
                    if(board.getBox(start.get_x() + i, start.get_y()).get_piece() != null)
                        return true;
            }
        }

        return false;
    }
}
