package com.solvd.atm;

import com.solvd.atm.models.ATM;
import com.solvd.atm.services.AccountService;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.utils.threads.AccountPool;

import javax.xml.bind.JAXBException;

import static com.solvd.atm.atm_menu.MainMenu.mainMenu;

public class Main {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    public static void main(String[] args) throws JAXBException {
        AccountPool.addAccountToPool(AccountService.getAllAccounts());
        boolean exit = false;
        while (!exit) {
            exit = mainMenu(false);
        }
    }
}
