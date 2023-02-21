package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.IBillDAO;
import com.solvd.atm.dao.utils.MyBatisDAO;
import com.solvd.atm.models.Bill;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BillDAO implements IBillDAO {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDAO.getSqlSessionFactory();
    private final SqlSession sqlSession = SESSION_FACTORY.openSession();
    private final IBillDAO iBillDAO = sqlSession.getMapper(IBillDAO.class);

    @Override
    public Bill getEntityById(long id) {
        return iBillDAO.getEntityById(id);
    }

    @Override
    public boolean updateEntity(long id_banknote, int banknote_count) {
        return iBillDAO.updateEntity(id_banknote, banknote_count);
    }

    @Override
    public List<Bill> getAllBills() {
        return iBillDAO.getAllBills();
    }

    @Override
    public List<Bill> getBillsByAtmId(long idATM) {
        return iBillDAO.getBillsByAtmId(idATM);
    }

    @Override
    public boolean updateEntity(Bill entity) {
        return iBillDAO.updateEntity(entity);
    }

    @Override
    public Bill createEntity(Bill entity) {
        return iBillDAO.createEntity(entity);
    }

    @Override
    public boolean removeEntity(long id) {
        return iBillDAO.removeEntity(id);
    }
}
