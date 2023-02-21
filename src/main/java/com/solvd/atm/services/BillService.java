package com.solvd.atm.services;

import com.solvd.atm.dao.IBillDAO;
import com.solvd.atm.dao.ICurrencyDAO;
import com.solvd.atm.dao.mysql.BillDAO;
import com.solvd.atm.dao.mysql.CurrencyDAO;
import com.solvd.atm.models.Bill;

import java.util.List;

public class BillService {
    private static final IBillDAO BILL_DAO = new BillDAO();

    private static final ICurrencyDAO CURRENCY_DAO = new CurrencyDAO();

    public static List<Bill> getBillsByATMId(long id) {
        List<Bill> result = BILL_DAO.getBillsByAtmId(id);
        result.forEach(b -> b.setCurrency(CURRENCY_DAO.getEntityById(b.getIdCurr()).getName()));
        return result;
    }

    public static boolean updateBill(Bill bill) {
        return BILL_DAO.updateEntity(bill.getIdBill(), bill.getCount());
    }
}
