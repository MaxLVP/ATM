package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.User;
import com.solvd.atm.services.AccountService;
import com.solvd.atm.services.UserService;
import com.solvd.atm.utils.MyLogger;

import java.util.List;
import java.util.Scanner;

public class TransferMenu {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void transferMoneyFromAccount(Account account) {
        LOGGER.info("Choose where you want to transfer money");
        LOGGER.info("1. Between you accounts");
        LOGGER.info("2. Transfer to another account");
        int point = SCANNER.nextInt();
        switch (point) {
            case 1 -> transferMoneyBetweenUserAccounts(account);
            case 2 -> {}
            default -> {
                LOGGER.info("You choose invalid point, try again :(");
                transferMoneyFromAccount(account);
            }
        }
    }

    public static void transferMoneyBetweenUserAccounts(Account account) {
        LOGGER.info("Choose id of account, you want to transfer money");
        User user = UserService.getUserByAccountID(account);
        List<Account> userAccountList = AccountService.getAllAccountsByUser(user);
        LOGGER.info("You accounts, please choose one");
        for (Account userAccount: userAccountList) {
            LOGGER.info(userAccount);
        }

    }
}
