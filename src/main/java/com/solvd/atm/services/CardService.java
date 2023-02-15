package com.solvd.atm.services;

import com.solvd.atm.dao.ICardDAO;
import com.solvd.atm.dao.mysql.CardDAO;

public class CardService {
    private static final ICardDAO CARD_DAO = new CardDAO();

    public static boolean validateCard(int number_card) {
        return CARD_DAO.getEntityByNumberCard(number_card) != null;
    }
}
