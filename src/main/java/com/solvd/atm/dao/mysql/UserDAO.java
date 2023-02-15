package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.IUserDAO;
import com.solvd.atm.models.User;

public class UserDAO implements IUserDAO {
    @Override
    public User getEntityById(long id) {
        return null;
    }

    @Override
    public boolean updateEntity(User entity) {
        return false;
    }

    @Override
    public User createEntity(User entity) {
        return null;
    }

    @Override
    public boolean removeEntity(long id) {
        return false;
    }
}
