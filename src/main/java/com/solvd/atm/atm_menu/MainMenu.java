package com.solvd.atm.atm_menu;

import com.solvd.atm.services.CardService;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.models.Card;
import com.solvd.atm.utils.threads.AccountPool;
import com.solvd.atm.utils.threads.AccountThread;

import java.util.Scanner;

public class MainMenu {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static boolean mainMenu(boolean exit) {
        AccountPool.getAccountPool();
        LOGGER.info("Welcome, choose what you want to do");
        LOGGER.info("1. Add card");
        LOGGER.info("2. Switch ATM");
        LOGGER.info("3. Quit");
        int point = SCANNER.nextInt();
        switch (point) {
            case 1 -> addCard();
            case 2 -> switchATM();
            case 3 -> exit = true;
            default -> {
                LOGGER.info("You choose invalid point, try again :(");
                mainMenu(exit);
            }
        }
        return exit;
    }

    public static void addCard() {
        AccountThread accountThread = new AccountThread();
        LOGGER.info("Write number of card that you insert");
        int cardNumber = Integer.parseInt(SCANNER.nextLine());
        Card card = CardService.validateCard(cardNumber);
        if (card != null) {
            LOGGER.info("Enter PIN of your card");
            int pin = Integer.parseInt(SCANNER.nextLine());
            if (card.getPin() == pin) {
                accountThread.getAccountByCard(card);
                new AccountThread().start();
            } else {
                LOGGER.info("Wrong PIN");
            }
        } else {
            LOGGER.info("Wrong card number");
        }
    }

    public static void switchATM() {
        LOGGER.info("Switching to ATM");
    }
}
