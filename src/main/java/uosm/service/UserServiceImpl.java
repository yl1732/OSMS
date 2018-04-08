package uosm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uosm.dao.UserDao;
import uosm.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Map<String,String> attenionMsg(String msg){
        Map<String,String> map = new HashMap<String, String>();
        map.put("msg",msg);
        return  map;
    }

    public Object signUser(User user) {
        if(userDao.selectByLoginName(user.getLogin_name())!=null){
            return attenionMsg("Sign Failed:User Exists Already");
        }
        else {
            userDao.insert(user);
            return userDao.selectTheUser(user);
        }
    }

    public Object loginUser(User user) {
        User userInDB = userDao.selectByLoginNameAndPwd(user.getLogin_name(),user.getPwd());
        if(userInDB!=null){
            return  userInDB;
        }
        else return attenionMsg("Login Failed:LoginName or Password Error");
    }

    public User selectUserById(Integer id) {
        return userDao.selectById(id);
    }

    public User selectUserByLoginName(String login_name) {
        return userDao.selectByLoginName(login_name);
    }

    public User selectTheUser(User user) {
        return userDao.selectTheUser(user);
    }

    public List<User> selectUsers(User user) {
        return userDao.select(user);
    }

    public Object updateUserWithId(User user) {
        if(user.getLogin_name()!=null && userDao.selectByLoginName(user.getLogin_name())!=null){
            return attenionMsg("User Exists Already");
        }
        else {
            userDao.updateWithId(user);
            return userDao.selectTheUser(user);
        }
    }

    public Integer deleteUserById(Integer id) {
        return userDao.deleteById(id);
    }

    public Integer deleteUserByLoginName(String login_name) {
        return userDao.deleteByLoginName(login_name);
    }
}
