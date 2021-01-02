package game;

import account.Player;
import board.*;
import enums.GameStatus;
import pieces.Piece;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static ArrayList<Move> _movesPlayed = new ArrayList<>();
    private GameStatus _gameStatus;
    private Player[] _players = new Player[2];
    private Board _board;
    private Player _currentTurn;

    private GameController _gc;

    public void newGame(Player p1, Player p2){
        this._players[0] = p1;
        this._players[1] = p2;

        _players[0].set_totalGamesPlayed(_players[0].get_totalGamesPlayed() + 1);
        _players[1].set_totalGamesPlayed(_players[1].get_totalGamesPlayed() + 1);

        Random rand = new Random();
        int p1whiteSide = rand.nextInt(2);

        if(p1whiteSide == 1) {
            _players[0].setWhiteSide(true);
            this._currentTurn = _players[0];
        }else {
            _players[1].setWhiteSide(true);
            this._currentTurn = _players[1];
        }

        _movesPlayed.clear();
        _gameStatus = GameStatus.ACTIVE;
        GameView.gameStartMessage(_players[0], _players[1], _players[0].isWhiteSide());
        _board = new Board();

        while(!isOver()) {
            GameView.showBoard(_board);
            //dangersUpdate();

            if(GameController.moveCreation(_currentTurn, _board)) {
                if (_currentTurn == _players[0])
                    _currentTurn = _players[1];
                else
                    _currentTurn = _players[0];
            }else
                System.out.println("Invalid move!");

            //if checkForAvailableMoves method returns false:
                //check if stalemate -> GameStatus.STALEMATE
                //check if white win -> GameStatus.WHITEWIN
                //check if black win -> GameStatus.BLACKWIN
                //check if resignation -> GameStatus.RESIGNATION
                //check if forfeit -> GameStatus.FORFEIT
                //continue;

        }

    }

    public boolean isOver(){
        if (_gameStatus == GameStatus.ACTIVE)
            return false;
        else
            return true;
    }

    public void dangerReset(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                _board.getBox(i, j).set_underP1control(false);
                _board.getBox(i, j).set_underP2control(false);
            }
        }
    }

    public GameController get_gc() {
        return _gc;
    }

    public void set_gc(GameController _gc) {
        this._gc = _gc;
    }

    /*
    public void dangersUpdate(){

        dangerReset();

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){

                Piece piece = this._board.getBox(i, j).get_piece();

                char result = piece.toString().substring(piece.toString().indexOf(".")).charAt(1);

                if(_players[0].isWhiteSide()){
                    try {

                        if (!piece.isWhite()) {
                            switch (result) {
                                case 'R':
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i + z, j).get_piece() == null)
                                            _board.getBox(i + z, j).set_underP2control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i - z, j).get_piece() == null)
                                            _board.getBox(i - z, j).set_underP2control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i, j + z).get_piece() == null)
                                            _board.getBox(i, j + z).set_underP2control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i, j - z).get_piece() == null)
                                            _board.getBox(i, j - z).set_underP2control(true);
                                        else
                                            break;
                                    }
                                    break;
                                case 'N':
                                    if(_board.getBox(i+2, j+1).get_piece() == null)
                                        _board.getBox(i+2, j+1).set_underP2control(true);
                                    if(_board.getBox(i+1, j+2).get_piece() == null)
                                        _board.getBox(i+1, j+2).set_underP2control(true);
                                    if(_board.getBox(i-2, j-1).get_piece() == null)
                                        _board.getBox(i-2, j-1).set_underP2control(true);
                                    if(_board.getBox(i-1, j-2).get_piece() == null)
                                        _board.getBox(i-1, j-2).set_underP2control(true);
                                    break;
                                case 'P':
                                    _board.getBox(i+1, j+1).set_underP2control(true);
                                    _board.getBox(i+1, j-1).set_underP2control(true);
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            switch (result) {
                                case 'R':
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i + z, j).get_piece() == null)
                                            _board.getBox(i + z, j).set_underP1control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i - z, j).get_piece() == null)
                                            _board.getBox(i - z, j).set_underP1control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i, j + z).get_piece() == null)
                                            _board.getBox(i, j + z).set_underP1control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i, j - z).get_piece() == null)
                                            _board.getBox(i, j - z).set_underP1control(true);
                                        else
                                            break;
                                    }
                                    break;
                                case 'N':
                                    if(_board.getBox(i+2, j+1).get_piece() == null)
                                        _board.getBox(i+2, j+1).set_underP1control(true);
                                    if(_board.getBox(i+1, j+2).get_piece() == null)
                                        _board.getBox(i+1, j+2).set_underP1control(true);
                                    if(_board.getBox(i-2, j-1).get_piece() == null)
                                        _board.getBox(i-2, j-1).set_underP1control(true);
                                    if(_board.getBox(i-1, j-2).get_piece() == null)
                                        _board.getBox(i-1, j-2).set_underP1control(true);
                                    break;
                                case 'P':
                                    _board.getBox(i+1, j+1).set_underP1control(true);
                                    _board.getBox(i+1, j-1).set_underP1control(true);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }catch (NullPointerException e){
                        break;
                    }
                }else{
                    try {
                        if (piece.isWhite()) {
                            switch (result) {
                                case 'R':
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i + z, j).get_piece() == null)
                                            _board.getBox(i + z, j).set_underP2control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i - z, j).get_piece() == null)
                                            _board.getBox(i - z, j).set_underP2control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i, j + z).get_piece() == null)
                                            _board.getBox(i, j + z).set_underP2control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i, j - z).get_piece() == null)
                                            _board.getBox(i, j - z).set_underP2control(true);
                                        else
                                            break;
                                    }
                                    break;
                                case 'N':
                                    if(_board.getBox(i+2, j+1).get_piece() == null)
                                        _board.getBox(i+2, j+1).set_underP2control(true);
                                    if(_board.getBox(i+1, j+2).get_piece() == null)
                                        _board.getBox(i+1, j+2).set_underP2control(true);
                                    if(_board.getBox(i-2, j-1).get_piece() == null)
                                        _board.getBox(i-2, j-1).set_underP2control(true);
                                    if(_board.getBox(i-1, j-2).get_piece() == null)
                                        _board.getBox(i-1, j-2).set_underP2control(true);
                                    break;
                                case 'P':
                                    _board.getBox(i+1, j+1).set_underP2control(true);
                                    _board.getBox(i+1, j-1).set_underP2control(true);
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            switch (result) {
                                case 'R':
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i + z, j).get_piece() == null)
                                            _board.getBox(i + z, j).set_underP1control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i - z, j).get_piece() == null)
                                            _board.getBox(i - z, j).set_underP1control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i, j + z).get_piece() == null)
                                            _board.getBox(i, j + z).set_underP1control(true);
                                        else
                                            break;
                                    }
                                    for (int z = 1; z <= 8-i; z++){
                                        if(_board.getBox(i, j - z).get_piece() == null)
                                            _board.getBox(i, j - z).set_underP1control(true);
                                        else
                                            break;
                                    }
                                    break;
                                case 'N':
                                    if(_board.getBox(i+2, j+1).get_piece() == null)
                                        _board.getBox(i+2, j+1).set_underP1control(true);
                                    if(_board.getBox(i+1, j+2).get_piece() == null)
                                        _board.getBox(i+1, j+2).set_underP1control(true);
                                    if(_board.getBox(i-2, j-1).get_piece() == null)
                                        _board.getBox(i-2, j-1).set_underP1control(true);
                                    if(_board.getBox(i-1, j-2).get_piece() == null)
                                        _board.getBox(i-1, j-2).set_underP1control(true);
                                    break;
                                case 'P':
                                    _board.getBox(i+1, j+1).set_underP1control(true);
                                    _board.getBox(i+1, j-1).set_underP1control(true);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }catch (NullPointerException e){
                        break;
                    }
                }
            }
        }
    }
    */

    public static void addMove (Move move){
        _movesPlayed.add(move);
    }

    public static ArrayList<Move> get_movesPlayed() {
        return _movesPlayed;
    }

    public static void set_movesPlayed(ArrayList<Move> _movesPlayed) {
        Game._movesPlayed = _movesPlayed;
    }
}
