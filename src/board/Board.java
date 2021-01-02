package board;

import pieces.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Board {
    private LocalDateTime _creationDate;
    private ArrayList<Piece> _pieces = new ArrayList<>();
    Box[][] board = new Box[8][8];

    public Board(){
        this._creationDate = LocalDateTime.now();
        this.resetBoard();
    }

    public Box getBox(int x, int y){
        return board[x][y];
    }

    public ArrayList<Piece> getPieces(){
        return _pieces;
    }

    public void resetBoard(){

        this._pieces.clear();

        //black pieces
        board[0][0] = new Box(new Rook(false), 0, 0);
        board[0][1] = new Box(new NKnight(false), 0, 1);
        board[0][2] = new Box(new Bishop(false), 0, 2);
        board[0][3] = new Box(new Queen(false), 0, 3);
        board[0][4] = new Box(new King(false), 0, 4);
        board[0][5] = new Box(new Bishop(false), 0, 5);
        board[0][6] = new Box(new NKnight(false), 0, 6);
        board[0][7] = new Box(new Rook(false), 0, 7);
        //black pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Box(new Pawn(false), 1, i);
            _pieces.add(board[0][i].get_piece());
            _pieces.add(board[1][i].get_piece());
        }

        //white pieces
        board[7][0] = new Box(new Rook(true), 7, 0);
        board[7][1] = new Box(new NKnight(true), 7, 1);
        board[7][2] = new Box(new Bishop(true), 7, 2);
        board[7][3] = new Box(new Queen(true), 7, 3);
        board[7][4] = new Box(new King(true), 7, 4);
        board[7][5] = new Box(new Bishop(true), 7, 5);
        board[7][6] = new Box(new NKnight(true), 7, 6);
        board[7][7] = new Box(new Rook(true), 7, 7);
        //white pawns
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Box(new Pawn(true), 6, i);
            _pieces.add(board[7][i].get_piece());
            _pieces.add(board[6][i].get_piece());
        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Box(null, i, j);
            }
        }
    }
}
