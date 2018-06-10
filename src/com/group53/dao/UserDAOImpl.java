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
import java.util.Locale;

public class UserDAOImpl implements UserDAO {

    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        Locale.setDefault(Locale.ENGLISH);
        this.template = template;
    }
    public void register(User user) {
        String student = "student";
        String sql = "insert into users values(?,?,?,?,?)";
        template.update(sql, new Object[] { user.getUsername(), user.getPassword(),student, user.getFirstname(),
                user.getLastname()});
    }
    public User validateUser(Login login) {
        String sql = "select * from users where username= ? and password=?" ;
        List<User> users = template.query(sql, new Object[]{login.getUsername(), login.getPassword()}, new UserMapper());
        System.out.println("result"+users.get(0));
        return users.size() > 0 ? users.get(0) : null;
    }

    public void updateRole(User user) {
        String sql = "UPDATE users SET role_id = ? WHERE username = ?";

        template.update(sql, new Object[] { user.getRole(), user.getUsername()});
    }


}

class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getNString("role_id"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));

        return user;
    }
}