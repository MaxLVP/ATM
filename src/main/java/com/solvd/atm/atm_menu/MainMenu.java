package com.solvd.atm.atm_menu;

import com.solvd.atm.models.ATM;
import com.solvd.atm.models.Account;
import com.solvd.atm.services.CardService;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.models.Card;
import com.solvd.atm.utils.collections.BlockedCardCollection;
import com.solvd.atm.utils.threads.WorkingWithPool;

import java.util.Scanner;

import static com.solvd.atm.atm_menu.working_with_card.MainMenu.mainCardMenu;

public class MainMenu {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ATM ATM_1 = new ATM(1);
    private static final ATM ATM_2 = new ATM(2);
    private static ATM CURRENT_ATM = ATM_1;
    private static Integer PIN_COUNTER = 0;

    public static boolean mainMenu(boolean exit) {
        LOGGER.info("Welcome to ATM №" + CURRENT_ATM.getId() + ", choose what you want to do");
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
        if (CURRENT_ATM.getCard() == null) {
            Card card = validateCard();
            Account account = WorkingWithPool.getAccountFromPool(card);
            if(account == null) {
                LOGGER.info("Firstly get back another card from ATM");
                mainMenu(false);
            } else {
                CURRENT_ATM.setCard(card);
                mainCardMenu(card, CURRENT_ATM);
            }
        }
        else {
            LOGGER.info("You already have card in this ATM, going to card menu");
            mainCardMenu(CURRENT_ATM.getCard(), CURRENT_ATM);
        }

    }

    public static Card validateCard() {
        LOGGER.info("Write number of card that you insert");
        int cardNumber = SCANNER.nextInt();
        Card card = CardService.validateCard(cardNumber);
        if (card != null && !BlockedCardCollection.checkIfCardBlocked(card)) {
            return validatePin(card);
        } else {
            LOGGER.info("Wrong card number or your card was block");
            mainMenu(false);
            return null;
        }
    }

    public static void switchATM() {
        if(CURRENT_ATM.getId() == 1) {
            LOGGER.info("Switching to ATM 2");
            CURRENT_ATM = ATM_2;
            mainMenu(false);
        } else if (CURRENT_ATM.getId() == 2) {
            LOGGER.info("Switching to ATM 1");
            CURRENT_ATM = ATM_1;
            mainMenu(false);
        }
    }

    public static Card validatePin(Card card) {
        LOGGER.info("Enter PIN of your card");
        int pin = SCANNER.nextInt();
        if (card.getPin() == pin && PIN_COUNTER < 4) {
            return card;
        } else if (PIN_COUNTER >= 4) {
            LOGGER.info("Sorry card is blocked");
            BlockedCardCollection.addToBlockedCard(card);
        } else {
            LOGGER.info("Wrong PIN, try again");
            PIN_COUNTER += 1;
            validatePin(card);
        }
        return null;
    }
}
