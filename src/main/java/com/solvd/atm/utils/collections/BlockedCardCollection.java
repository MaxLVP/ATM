package com.solvd.atm.utils.collections;

import com.solvd.atm.models.Card;

import java.util.ArrayList;
import java.util.List;

public class BlockedCardCollection {
    private static final List<Card> CARD_LIST = new ArrayList<>();

    public static List<Card> getAllBlockedCard() {
        return CARD_LIST;
    }

    public static void addToBlockedCard(Card card) {
        CARD_LIST.add(card);
    }

    public static boolean checkIfCardBlocked(Card card) {
        return CARD_LIST.contains(card);
    }
}
