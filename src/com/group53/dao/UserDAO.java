package com.group53.dao;

import com.group53.beans.Login;
import com.group53.beans.User;

public interface UserDAO {
    void register(User user);
    User validateUser(Login login);
}
