package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.ICardDAO;
import com.solvd.atm.models.Card;

public class CardDAO implements ICardDAO {
    @Override
    public Card getEntityById(long id) {
        return null;
    }

    @Override
    public boolean updateEntity(Card entity) {
        return false;
    }

    @Override
    public Card createEntity(Card entity) {
        return null;
    }

    @Override
    public boolean removeEntity(long id) {
        return false;
    }
}
