package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.ICurrencyDAO;
import com.solvd.atm.models.Currency;

public class CurrencyDAO implements ICurrencyDAO {
    @Override
    public Currency getEntityById(long id) {
        return null;
    }

    @Override
    public boolean updateEntity(Currency entity) {
        return false;
    }

    @Override
    public Currency createEntity(Currency entity) {
        return null;
    }

    @Override
    public boolean removeEntity(long id) {
        return false;
    }
}
