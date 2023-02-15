package com.solvd.atm;

import static com.solvd.atm.atm_menu.MainMenu.mainMenu;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            exit = mainMenu(false);
        }
    }
}
