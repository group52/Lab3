package com.group53.dao;

import com.group53.beans.Login;
import com.group53.beans.User;

import java.sql.SQLException;

public interface UserDAO {
    void register(User user) throws SQLException;
    User validateUser(Login login);
    void updateRole(User user);
}
