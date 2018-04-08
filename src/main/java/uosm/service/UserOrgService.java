package uosm.service;

import uosm.model.Org;
import uosm.model.User;
import uosm.model.UserOrg;

import java.util.List;

public interface UserOrgService {

    //user
    Object addUserWithOrgs(User user, List<Org> orgs);
    Object callUserInOrgs(User user,List<Org> orgs);
    Object callUserOffOrgs(User user,List<Org> orgs);
    Object deleteUserAndOrgs(User user);
    List<Org> getOrgsByUserId(Integer user_id);

    //org
    Object addOrgWithUsers(Org org, List<User> users);
    Object addUsersToOrg(Org org,List<User> users);
    Object deleteUsersFromOrg(Org org,List<User> users);
    Object deleteOrgAndUsers(Org org);
    List<User> getUsersByOrgId(Integer org_id);

    //user_org
    Integer updateUserOrg(UserOrg userOrg);

}
