package account;

import datatypes.Person;
import enums.AccountStatus;
import game.GameView;

public class Player extends Account{
    private Person _person;
    private int _totalGamesPlayed;
    private boolean whiteSide = false;
    private boolean _checked = false;

    private GameView _gameView;

    public Player(Person _person, int _totalGamesPlayed) {
        this._person = _person;
        this._totalGamesPlayed = _totalGamesPlayed;
    }

    public Player(int _id, String _password, AccountStatus _accountStatus, Person _person, int _totalGamesPlayed) {
        super(_id, _password, _accountStatus);
        this._person = _person;
        this._totalGamesPlayed = _totalGamesPlayed;
    }

    public boolean is_checked() {
        return _checked;
    }

    public void set_checked(boolean _checked) {
        this._checked = _checked;
    }

    public boolean isWhiteSide(){
        return this.whiteSide;
    }

    public Person get_person() {
        return _person;
    }

    public void set_person(Person _person) {
        this._person = _person;
    }

    public GameView get_gameView() {
        return _gameView;
    }

    public void set_gameView(GameView _gameView) {
        this._gameView = _gameView;
    }

    public int get_totalGamesPlayed() {
        return _totalGamesPlayed;
    }

    public void set_totalGamesPlayed(int _totalGamesPlayed) {
        this._totalGamesPlayed = _totalGamesPlayed;
    }

    public void setWhiteSide(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }
}
