package uosm.dao;

import uosm.model.Org;
import uosm.model.User;
import uosm.model.UserOrg;

import java.util.List;

public interface UserOrgDao {
    Integer insert(List<UserOrg> userOrgs);
    UserOrg selectTheUserOrg(UserOrg userOrg);
    List<Org> selectOrgsByUserId(Integer user_id);
    List<User> selectUsersByOrgId(Integer org_id);
    Integer updateWithId(UserOrg userOrg);
    Integer delete(List<UserOrg> userOrgs);
    Integer deleteAllOrgsByUserId(Integer user_id);
    Integer deleteAllUsersByOrgId(Integer org_id);
}
