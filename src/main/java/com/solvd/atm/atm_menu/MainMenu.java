package com.solvd.atm.atm_menu;

import com.solvd.atm.Utils.MyLogger;

import java.util.Scanner;

public class MainMenu {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static boolean mainMenu(boolean exit) {
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
        LOGGER.info("Write number of card that you insert");
        String cardNumber = SCANNER.nextLine();
    }

    public static void switchATM() {
        LOGGER.info("Switching to ATM");
    }
}
