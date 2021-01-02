package pieces;

import account.Player;
import board.Board;
import board.Box;
import game.Move;

public class King extends Piece{
    private boolean _castlingDone = false;
    private boolean hasMovedBefore = false;

    public King(boolean _white) {
        super(_white);
    }

    public boolean is_castlingDone() {
        return _castlingDone;
    }

    public void set_castlingDone(boolean _castlingDone) {
        this._castlingDone = _castlingDone;
    }

    @Override
    public boolean canMove(Board board, Box start, Box finish) {

        boolean result = false;

        if((start.get_x() == finish.get_x() + 1) || (start.get_x() == finish.get_x() - 1))
            result = true;
        if((start.get_y() == finish.get_y() + 1) || (start.get_y() == finish.get_y() - 1))
            result = true;


        System.out.println(start.get_x() + " " + start.get_y());

        if(isWhite()) {
            if (!hasMovedBefore && ((finish.get_y() == 2 && board.getBox(7, 0).get_piece().getClass() == new Rook(true).getClass() && board.getBox(7, 1).get_piece() == null && board.getBox(7, 2).get_piece() == null && board.getBox(7, 3).get_piece() == null) || (finish.get_y() == 6 && board.getBox(7, 7).get_piece().getClass() == new Rook(true).getClass() && board.getBox(7, 6).get_piece() == null && board.getBox(7, 5).get_piece() == null))){
                set_castlingDone(true);
                result = true;
                if(finish.get_y() == 2){
                    board.getBox(7, 0).set_piece(null);
                    board.getBox(7, 2).set_piece(new Rook(true));
                }
                if(finish.get_y() == 6){
                    board.getBox(7, 7).set_piece(null);
                    board.getBox(7, 5).set_piece(new Rook(true));
                }
            }
        }else{
            if (!hasMovedBefore && ((finish.get_y() == 2 && board.getBox(0, 0).get_piece().getClass() == new Rook(false).getClass() && board.getBox(0, 1).get_piece() == null && board.getBox(0, 2).get_piece() == null && board.getBox(0, 3).get_piece() == null) || (finish.get_y() == 6 && board.getBox(0, 7).get_piece().getClass() == new Rook(false).getClass() && board.getBox(0, 6).get_piece() == null && board.getBox(0, 5).get_piece() == null))){
                set_castlingDone(true);
                result = true;
                if(finish.get_y() == 2){
                    board.getBox(0, 0).set_piece(null);
                    board.getBox(0, 2).set_piece(new Rook(false));
                }
                if(finish.get_y() == 6){
                    board.getBox(0, 7).set_piece(null);
                    board.getBox(0, 5).set_piece(new Rook(false));
                }
            }
        }

        if (result == true)
            hasMovedBefore = true;

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
