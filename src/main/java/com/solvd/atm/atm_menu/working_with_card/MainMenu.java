package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.Card;

import static com.solvd.atm.atm_menu.working_with_card.CardMenu.cardMenu;

public class MainMenu {

    public static void mainCardMenu(Card card) {
        boolean exit = false;
        while (!exit) {
            exit = cardMenu(false, card);
        }
    }
}
