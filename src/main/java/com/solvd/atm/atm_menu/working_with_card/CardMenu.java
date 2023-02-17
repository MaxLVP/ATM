package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.ATM;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.models.Account;
import com.solvd.atm.utils.collections.AllChecksCollection;
import com.solvd.atm.utils.parsers.XmlParser;
import com.solvd.atm.utils.threads.AccountPool;

import java.util.Scanner;

import static com.solvd.atm.atm_menu.MainMenu.mainMenu;

public class CardMenu {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static boolean cardMenu(boolean exit, Account account, ATM atm) {
        LOGGER.info("Welcome, choose what you want to do");
        LOGGER.info("1. Withdraw money from account");
        LOGGER.info("2. Add money to account");
        LOGGER.info("3. Watch balance on account");
        LOGGER.info("4. Transfer money to another account");
        LOGGER.info("5. Pay bill");
        LOGGER.info("6. Exit to menu");
        LOGGER.info("7. Take off card");
        int point = SCANNER.nextInt();
        switch (point) {
            case 1 -> WithdrawMenu.withdrawMoneyFromAccount(account, atm);
            case 2 -> AddingMoneyMenu.addMoneyToAccount(account, atm);
            case 3 -> AccountInfoMenu.getMoneyInfo(account);
            case 4 -> TransferMenu.transferMoneyFromAccount(account);
            case 5 -> BillsMenu.payBills(account);
            case 6 -> mainMenu(false);
            case 7 -> {
                exit = true;
                new AccountPool().releaseAccount(account);
                LOGGER.info(AllChecksCollection.getAllChecks());
                XmlParser.writeToXml();
            }
            default -> {
                LOGGER.info("You choose invalid point, try again :(");
                cardMenu(exit, account, atm);
            }
        }
        return exit;
    }
}
