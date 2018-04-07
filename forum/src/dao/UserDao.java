package dao;

import domain.User;

/**
 * Created by slzZp on 2018/1/31.
 */
public interface UserDao {
    public User findUserById(int id) throws Exception;
}
