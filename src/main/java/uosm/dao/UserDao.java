package uosm.dao;

import org.apache.ibatis.annotations.Param;
import uosm.model.User;

import java.util.List;

public interface UserDao {

    Integer insert(User user);
    User selectById(Integer id);
    User selectByLoginName(String login_name);
    User selectByLoginNameAndPwd(@Param("login_name") String login_name, @Param("pwd") String pwd);
    User selectTheUser(User user);
    List<User> select(User user);
    Integer updateWithId(User user);
    Integer deleteById(Integer id);
    Integer deleteByLoginName(String login_name);
}
