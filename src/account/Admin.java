package account;

import enums.AccountStatus;

import java.util.ArrayList;

public class Admin extends Account{
    public Admin() {
    }

    public Admin(int _id, String _password, AccountStatus _accountStatus) {
        super(_id, _password, _accountStatus);
    }

    public boolean blockUser(Player p){
        p.set_accountStatus(AccountStatus.BLACKLISTED);
        return true;
    }
}
