package com.example.demo.service.impl;

import com.example.demo.dao.impl.UserDaoImpl;
import com.example.demo.exception.DaoException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String login, String password) throws ServiceException {
        //validate login,pass + md5
        boolean match = false;
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            match = userDao.authenticate(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return match;
    }
}
