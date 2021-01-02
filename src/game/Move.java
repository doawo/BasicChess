package game;

import account.Player;
import board.Box;
import pieces.Piece;

public class Move {
    private Box _startBox, _endingBox;
    private Piece _pieceKilled;
    private Player _player;
    private boolean _isCastlingMove;

    public Move(Box _startBox, Box _endingBox, Player _player) {
        this._startBox = _startBox;
        this._endingBox = _endingBox;
        this._player = _player;
    }

    public Move(Box _startBox, Box _endingBox, Piece _pieceKilled, Player _player, boolean _isCastlingMove) {
        this._startBox = _startBox;
        this._endingBox = _endingBox;
        this._pieceKilled = _pieceKilled;
        this._player = _player;
        this._isCastlingMove = _isCastlingMove;
    }

    public Box get_startBox() {
        return _startBox;
    }

    public void set_startBox(Box _startBox) {
        this._startBox = _startBox;
    }

    public Box get_endingBox() {
        return _endingBox;
    }

    public void set_endingBox(Box _endingBox) {
        this._endingBox = _endingBox;
    }

    public Piece get_pieceKilled() {
        return _pieceKilled;
    }

    public void set_pieceKilled(Piece _pieceKilled) {
        this._pieceKilled = _pieceKilled;
    }

    public Player get_player() {
        return _player;
    }

    public void set_player(Player _player) {
        this._player = _player;
    }

    public boolean is_isCastlingMove() {
        return _isCastlingMove;
    }

    public void set_isCastlingMove(boolean _isCastlingMove) {
        this._isCastlingMove = _isCastlingMove;
    }
}
