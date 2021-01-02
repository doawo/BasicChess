package board;

import pieces.*;

public class Box {
    private Piece _piece;
    private int _x, _y;
    private boolean _underP1control = false, _underP2control = false;

    public Box() {
    }

    public Box(Piece _piece, int _x, int _y) {
        this._piece = _piece;
        this._x = _x;
        this._y = _y;
    }

    public Piece get_piece() {
        return _piece;
    }

    public void set_piece(Piece _piece) {
        this._piece = _piece;
    }

    public int get_x() {
        return _x;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public int get_y() {
        return _y;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public boolean is_underP1control() {
        return _underP1control;
    }

    public void set_underP1control(boolean _underP1control) {
        this._underP1control = _underP1control;
    }

    public boolean is_underP2control() {
        return _underP2control;
    }

    public void set_underP2control(boolean _underP2control) {
        this._underP2control = _underP2control;
    }
}
