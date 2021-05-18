package Mapper;

import Model.User;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("NETNAME"));
        user.setFirst_name(rs.getString("FIRSTNAME"));
        user.setLast_name(rs.getString("LASTNAME"));
        return user;
    }

}