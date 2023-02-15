package com.solvd.atm;

import com.solvd.atm.models.ATM;
import com.solvd.atm.services.AccountService;
import com.solvd.atm.utils.threads.AccountPool;

import static com.solvd.atm.atm_menu.MainMenu.mainMenu;

public class Main {
    public static void main(String[] args) {
        AccountPool.addAccountToPool(AccountService.getAllAccounts());
        ATM atm = new ATM(1);
        boolean exit = false;
        while (!exit) {
            exit = mainMenu(false, atm);
        }
    }
}
