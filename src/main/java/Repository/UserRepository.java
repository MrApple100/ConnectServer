package Repository;

import Mapper.UserMapper;
import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createUser(User user){
        return jdbcTemplate.update("INSERT INTO \"USERS\" (\"FIRSTNAME\") VALUES(?), (\"LASTNAME\") VALUES(?), (\"NETNAME\") INTEGER", user.getFirst_name(),user.getLast_name(),Integer.parseInt(user.getId().toString()));
    }

    public int updateUser(User user){
        return jdbcTemplate.update("UPDATE \"USERS\" SET \"FIRSTNAME\" = ? , \"LASTNAME\" WHERE \"NETNAME\" = ?", user.getFirst_name(),user.getLast_name(), Integer.parseInt(user.getId().toString()));
    }

    public int deleteUser(Integer id){
        return jdbcTemplate.update("DELETE FROM \"USERS\" WHERE \"NETNAME\" = ?",id);
    }

    public User getUser(Integer id){
        return jdbcTemplate.queryForObject("SELECT * FROM \"USERS\" WHERE \"NETNAME\"=?", new UserMapper(), id);
    }

    public List<User> getUsers(){
        return jdbcTemplate.query("SELECT * FROM \"USERS\"", new UserMapper());
    }
}
