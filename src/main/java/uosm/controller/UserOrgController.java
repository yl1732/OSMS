package uosm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uosm.model.Org;
import uosm.model.User;
import uosm.model.UserOrg;
import uosm.service.UserOrgService;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class UserOrgController {

    @Autowired
    private UserOrgService userOrgService;

    //user
    @RequestMapping(value = "/addUserWithOrgs",method = RequestMethod.POST)
    public Object addUserWithOrgs(@RequestBody @Valid UserOrgs userOrgs,Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return userOrgService.addUserWithOrgs(userOrgs.user,userOrgs.orgs);
    }

    @RequestMapping(value = "/callUserInOrgs",method = RequestMethod.POST)
    public Object callUserInOrgs(@RequestBody @Valid UserOrgs userOrgs,Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return userOrgService.callUserInOrgs(userOrgs.user,userOrgs.orgs);
    }

    @RequestMapping(value = "/callUserOffOrgs",method = RequestMethod.POST)
    public Object callUserOffOrgs(@RequestBody @Valid UserOrgs userOrgs,Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return userOrgService.callUserOffOrgs(userOrgs.user,userOrgs.orgs);
    }

    @RequestMapping(value = "/deleteUserAndOrgs",method = RequestMethod.POST)
    public Object deleteUserAndOrgs(@RequestBody User user){
        return userOrgService.deleteUserAndOrgs(user);
    }

    @RequestMapping(value = "/getOrgsByUserId",method = RequestMethod.POST)
    public List<Org> getOrgsByUserId(@RequestBody Integer user_id){
        return userOrgService.getOrgsByUserId(user_id);
    }


    //org
    @RequestMapping(value = "/addOrgWithUsers",method = RequestMethod.POST)
    public Object addOrgWithUsers(@RequestBody @Valid OrgUsers orgUsers,Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return userOrgService.addOrgWithUsers(orgUsers.org,orgUsers.users);
    }

    @RequestMapping(value = "/addUsersToOrg",method = RequestMethod.POST)
    public Object addUsersToOrg(@RequestBody @Valid OrgUsers orgUsers,Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return userOrgService.addUsersToOrg(orgUsers.org,orgUsers.users);
    }

    @RequestMapping(value = "/deleteUsersFromOrg",method = RequestMethod.POST)
    public Object deleteUsersFromOrg(@RequestBody @Valid OrgUsers orgUsers,Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return userOrgService.deleteUsersFromOrg(orgUsers.org,orgUsers.users);
    }

    @RequestMapping(value = "/deleteOrgAndUsers",method = RequestMethod.POST)
    public Object deleteOrgAndUsers(@RequestBody Org org){
        return userOrgService.deleteOrgAndUsers(org);
    }

    @RequestMapping(value = "/getUsersByOrgId",method = RequestMethod.POST)
    public List<User> getUsersByOrgId(@RequestBody Integer org_id){
        return userOrgService.getUsersByOrgId(org_id);
    }


    //userorg
    @RequestMapping(value = "/updateUserOrg",method = RequestMethod.POST)
    public Integer updateUserOrg(@RequestBody UserOrg userOrg){
        return userOrgService.updateUserOrg(userOrg);
    }

}



//数据封装类
class UserOrgs{
    @NotNull(message = "User Must Not Be Null")
    public User user;
    @NotNull(message = "Orgs Must Not Be Null")
    public List<Org> orgs;
}

class OrgUsers{
    @NotNull(message = "Org Must Not Be Null")
    public Org org;

    @NotNull(message = "Users Must Not Be Null")
    public List<User> users;
}
