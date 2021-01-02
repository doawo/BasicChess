package game;

import account.Player;
import board.Board;
import pieces.Piece;

public class GameView {

    private Game _game;

    public static void welcomeMessage(){
        System.out.println("Welcome to Chess!");
        System.out.println("Would you like to play? (2p)");
        System.out.println("1. Yes");
        System.out.println("0. Exit");
    }

    public static void gameStartMessage(Player p1, Player p2, boolean p1white){
        System.out.println("The new game between " + p1.get_person().get_name() + " and " + p2.get_person().get_name() + " has begun!");
        System.out.println("Players, get ready");
        System.out.print("White side is played by: ");
        if(p1white)
            System.out.println(p1.get_person().get_name());
        else
            System.out.println(p2.get_person().get_name());
    }

    public static void moveMessage(Player currentPlayer){
        System.out.println(currentPlayer.get_person().get_name() + "'s turn to move");
        System.out.print("Choose what piece to touch (e.g. H7): ");
    }

    public static void whereToMove(){
        System.out.print("Where to place it: ");
    }

    public static void showBoard(Board board){
        System.out.println("    #1\u2001#2\u2001#3\u2001#4\u2001#5\u2001#6\u2001#7\u2001#8");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(j==0){
                    System.out.print("(" + Character.toString(i+65) + ")");
                }
                System.out.print("[" + translatePieceToVisual(board.getBox(i, j).get_piece()) + "]");
            }
            System.out.print("\n");
        }
    }

    public static String translatePieceToVisual(Piece piece){
        try {
            char result = piece.toString().substring(piece.toString().indexOf(".")).charAt(1);
            if (piece.isWhite()) {
                switch (result) {
                    case 'R':
                        return "\u2656";
                    case 'N':
                        return "\u2658";
                    case 'B':
                        return "\u2657";
                    case 'Q':
                        return "\u2655";
                    case 'K':
                        return "\u2654";
                    case 'P':
                        return "\u2659";
                    default:
                        return "\u2001";
                }
            } else {
                switch (result) {
                    case 'R':
                        return "\u265c";
                    case 'N':
                        return "\u265e";
                    case 'B':
                        return "\u265d";
                    case 'Q':
                        return "\u265b";
                    case 'K':
                        return "\u265a";
                    case 'P':
                        return "\u265f";
                    default:
                        return "\u2001";
                }
            }
        }catch (NullPointerException e){
            return "\u2001";
        }
    }

    public Game get_game() {
        return _game;
    }

    public void set_game(Game _game) {
        this._game = _game;
    }
}
