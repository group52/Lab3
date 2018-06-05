package com.group53.dao;

import com.group53.beans.Login;
import com.group53.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Autowired
    DataSource datasource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void register(User user) {
        String sql = "insert into users values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[] { user.getLogin(), user.getPassword(), user.getFirstname(),
                user.getLastname()});
    }
    public User validateUser(Login login) {
        String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
                + "'";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;
    }
}
class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getNString("role"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));

        return user;
    }
}
