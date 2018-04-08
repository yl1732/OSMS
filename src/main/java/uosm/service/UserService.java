package uosm.service;

import uosm.model.User;

import java.util.List;

public interface UserService {

    Object signUser(User user);
    Object loginUser(User user);
    User selectUserById(Integer id);
    User selectUserByLoginName(String login_name);
    User selectTheUser(User user);
    List<User> selectUsers(User user);
    Object updateUserWithId(User user);
    Integer deleteUserById(Integer id);
    Integer deleteUserByLoginName(String login_name);
}
