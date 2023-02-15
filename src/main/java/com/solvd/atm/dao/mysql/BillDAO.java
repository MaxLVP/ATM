package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.IBillDAO;
import com.solvd.atm.models.Bill;

public class BillDAO implements IBillDAO {
    @Override
    public Bill getEntityById(long id) {
        return null;
    }

    @Override
    public boolean updateEntity(Bill entity) {
        return false;
    }

    @Override
    public Bill createEntity(Bill entity) {
        return null;
    }

    @Override
    public boolean removeEntity(long id) {
        return false;
    }
}
