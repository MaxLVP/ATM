package com.solvd.atm.services;

import com.solvd.atm.dao.ICardDAO;
import com.solvd.atm.dao.mysql.CardDAO;
import com.solvd.atm.models.Card;

public class CardService {
    private static final ICardDAO CARD_DAO = new CardDAO();

    public static Card validateCard(int number_card) {
        return CARD_DAO.getEntityByNumberCard(number_card);
    }
}
