package com.solvd.atm;

import com.solvd.atm.services.AccountService;
import com.solvd.atm.utils.parsers.CurrencyParser;
import com.solvd.atm.utils.threads.AccountPool;

import static com.solvd.atm.atm_menu.MainMenu.mainMenu;

public class Main {
    public static void main(String[] args) {
        CurrencyParser.updateCurrency();
        AccountPool.addAccountToPool(AccountService.getAllAccounts());
        boolean exit = false;
        while (!exit) {
            exit = mainMenu(false);
       }
    }
}
