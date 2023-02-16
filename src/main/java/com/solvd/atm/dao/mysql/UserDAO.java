package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.IUserDAO;
import com.solvd.atm.dao.utils.MyBatisDAO;
import com.solvd.atm.models.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDAO implements IUserDAO {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDAO.getSqlSessionFactory();
    private final SqlSession sqlSession = SESSION_FACTORY.openSession();
    private final IUserDAO iUserDAO = sqlSession.getMapper(IUserDAO.class);

    @Override
    public User getEntityById(long id) {
        return iUserDAO.getEntityById(id);
    }

    @Override
    public boolean updateEntity(long id_user, String first_name, String last_name, int passport_ID) {
        try {
            iUserDAO.updateEntity(id_user, first_name, last_name, passport_ID);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
        return true;
    }

    @Override
    public boolean updateEntity(User entity) {
        return false;
    }

    @Override
    public User createEntity(User entity) {
        User u = null;
        try {
            u = iUserDAO.createEntity(entity);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
        return u;
    }

    @Override
    public boolean removeEntity(long id) {
        try {
            iUserDAO.removeEntity(id);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
        return true;
    }

    @Override
    public User getEntityByAccountId(long id) {
        return iUserDAO.getEntityByAccountId(id);
    }
}
