package uosm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uosm.model.User;
import uosm.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/signUser",method = RequestMethod.POST)
    public Object signUser(@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return userService.signUser(user);
    }

    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public Object loginUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return userService.loginUser(user);
    }

    @RequestMapping(value = "/selectUserById",method = RequestMethod.POST)
    public User selectUserById(@RequestBody Integer id){
        return userService.selectUserById(id);
    }

    @RequestMapping(value = "/selectUserByLoginName",method = RequestMethod.POST)
    public User selectUserByLoginName(@RequestBody String login_name){
        return userService.selectUserByLoginName(login_name);
    }

    @RequestMapping(value = "/selectTheUser",method = RequestMethod.POST)
    public User selectTheUser(@RequestBody User user){
        return userService.selectTheUser(user);
    }

    @RequestMapping(value = "/selectUsers",method = RequestMethod.POST)
    public List<User> selectUsers(@RequestBody User user){
        return userService.selectUsers(user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public Object updateUserWithId(@RequestBody User user){
        return userService.updateUserWithId(user);
    }

    @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
    public Integer deleteUserById(@RequestBody Integer id){
        return userService.deleteUserById(id);
    }

    @RequestMapping(value = "/deleteUserByLoginName",method = RequestMethod.POST)
    public Integer deleteUserByLoginName(@RequestBody String login_name){
        return userService.deleteUserByLoginName(login_name);
    }

}
