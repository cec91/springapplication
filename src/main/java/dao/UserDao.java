package dao;

import entities.User;

/**
 * Created by vsantucc on 16/05/2017.
 */
public interface UserDao {
    User getUserByName(String name);
    void insertUser();

}
