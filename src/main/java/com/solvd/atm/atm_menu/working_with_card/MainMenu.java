package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.ATM;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Card;
import com.solvd.atm.services.AccountService;

import static com.solvd.atm.atm_menu.working_with_card.CardMenu.cardMenu;

public class MainMenu {

    public static void mainCardMenu(Card card, ATM atm) {
        Account account = AccountService.getAccountByCard(card);
        boolean exit = false;
        while (!exit) {
            exit = cardMenu(false, account, atm);
        }
    }
}
