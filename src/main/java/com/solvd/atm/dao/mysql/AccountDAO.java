package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.IAccountDAO;
import com.solvd.atm.models.Account;

public class AccountDAO implements IAccountDAO {
    @Override
    public Account getEntityById(long id) {
        return null;
    }

    @Override
    public boolean updateEntity(Account entity) {
        return false;
    }

    @Override
    public Account createEntity(Account entity) {
        return null;
    }

    @Override
    public boolean removeEntity(long id) {
        return false;
    }
}
