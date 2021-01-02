package account;

import enums.AccountStatus;

public class Account {
    private int _id;
    private String _password;
    private AccountStatus _accountStatus;

    public Account() {
    }

    public Account(int _id, String _password, AccountStatus _accountStatus) {
        this._id = _id;
        this._password = _password;
        this._accountStatus = _accountStatus;
    }

    private boolean resetPassword(String newPassword){
        this._password = newPassword;
        return true;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public AccountStatus get_accountStatus() {
        return _accountStatus;
    }

    public void set_accountStatus(AccountStatus _accountStatus) {
        this._accountStatus = _accountStatus;
    }
}
