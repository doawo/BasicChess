package game;

import account.Player;
import board.Board;
import board.Box;
import pieces.Piece;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    public static ArrayList<Box> p1dangerBoxes = new ArrayList<>();
    public static ArrayList<Box> p2dangerBoxes = new ArrayList<>();

    private Player _currentPlayer;

    public static boolean moveCreation(Player currentPlayer, Board board){
        GameView.moveMessage(currentPlayer);
        String input;
        Scanner sc = new Scanner(System.in);
        try{
            input = sc.next();
        }catch (StringIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Wrong input!");
            moveCreation(currentPlayer, board);
            return false;
        }
        input = input.toLowerCase();

        Character moveLetter = input.charAt(0);

        if (translateLetter(moveLetter) == -1){
            System.out.println("Incorrect move!");
            moveCreation(currentPlayer, board);
            return false;
        }

        int moveLine = translateLetter(moveLetter);
        String colToParse = "" + input.charAt(1);
        int moveCol = Integer.parseInt(colToParse) - 1;

        Box currentPiece = board.getBox(moveLine, moveCol);

        if ((currentPiece.get_piece() != null) && (currentPiece.get_piece().isWhite() != currentPlayer.isWhiteSide()))
            return false;

        if (currentPiece.get_piece() == null)
            return false;

        GameView.whereToMove();
        try{
            input = sc.next();
        }catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Wrong input!");
            moveCreation(currentPlayer, board);
            return false;
        }

        input = input.toLowerCase();

        moveLetter = input.charAt(0);

        if (translateLetter(moveLetter) == -1){
            System.out.println("Incorrect move!");
            moveCreation(currentPlayer, board);
            return false;
        }

        moveLine = translateLetter(moveLetter);
        colToParse = "" + input.charAt(1);
        moveCol = Integer.parseInt(colToParse) - 1;

        Box destPlace = board.getBox(moveLine, moveCol);

        Move move = new Move(currentPiece, destPlace, currentPlayer);

        if(validateMove(move, currentPlayer, board)){
            Game.addMove(move);

            if (move.get_endingBox().get_piece() != null)
                move.get_endingBox().get_piece().set_killed(true);

            move.get_endingBox().set_piece(move.get_startBox().get_piece());
            move.get_startBox().set_piece(null);
        }else
            return false;

        return true;

    }

    public static boolean validateMove(Move move, Player player, Board board){
        Piece piece = move.get_startBox().get_piece();
        if(piece == null)
            return false;

        if(piece.isWhite() != player.isWhiteSide())
            return false;

        if((move.get_endingBox().get_piece() != null) && (piece.isWhite() == move.get_endingBox().get_piece().isWhite()))
            return false;

        if (!piece.canMove(board, move.get_startBox(), move.get_endingBox()))
            return false;

        return true;
    }

    public static int translateLetter(Character moveLetter){
        switch(moveLetter){
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                return -1;
        }
    }

    public Player get_currentPlayer() {
        return _currentPlayer;
    }

    public void set_currentPlayer(Player _currentPlayer) {
        this._currentPlayer = _currentPlayer;
    }
}
