package com.solvd.atm.services;

import com.solvd.atm.dao.IFineDAO;
import com.solvd.atm.dao.mysql.FineDAO;
import com.solvd.atm.models.Fine;

public class FineService {
    private static final IFineDAO FINE_DAO = new FineDAO();

    public static Fine getFine(long id_fine) {
        return FINE_DAO.getEntityById(id_fine);
    }
}
