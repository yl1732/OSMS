package uosm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uosm.dao.UserOrgDao;
import uosm.model.Org;
import uosm.model.User;
import uosm.model.UserOrg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("userOrgService")
public class UserOrgServiceImpl implements UserOrgService {
    @Autowired
    private UserOrgDao userOrgDao;

    @Autowired
    private UserService userService;

    @Autowired
    private OrgService orgService;

    public Map<String,String> attenionMsg(String msg){
        Map<String,String> map = new HashMap<String, String>();
        map.put("msg",msg);
        return  map;
    }
    public Map<String,Object> result(Object objFir,Object objSec){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("firstRst",objFir);
        map.put("secondRst",objSec);
        return  map;
    }
    public List<UserOrg> confirmUserOrgsByUserOrgs(User user,List<Org> orgs){

        //User 存在性检测
        if(userService.selectTheUser(user)==null){
            return null;
        }
        //orgs 确认
        List<Org> orgsInDB=new ArrayList<Org>();
        for(int i=0;i<orgs.size();i++){
            Org orgInDB =orgService.selectTheOrg(orgs.get(i));
            if(orgInDB!=null){
                orgsInDB.add(orgInDB);
            }
            else return null;
        }

        Integer id=userService.selectTheUser(user).getId();

        //UserOrgs初始化
        List<UserOrg> userOrgs=new ArrayList<UserOrg>();
        for(int i=0;i<orgsInDB.size();i++){
            UserOrg userOrg =new UserOrg();
            userOrg.setUser_id(id);
            userOrg.setOrg_id(orgsInDB.get(i).getId());
            if(userOrgDao.selectTheUserOrg(userOrg)==null){
                userOrgs.add(userOrg);
            }
        }
        if(userOrgs.isEmpty()){
            return null;
        }
        else return userOrgs;
    }
    public List<UserOrg> confirmOrgUsersByOrgUsers(Org org,List<User> users){
        //org检测
        if(orgService.selectTheOrg(org)==null){
            return null;
        }
        //users 检测
        List<User> usersInDB = new ArrayList<User>();
        for(int i=0;i<users.size();i++){
            User userInDB=userService.selectTheUser(users.get(i));
            if(userInDB!=null){ //存在则暂存入memsInDB
                usersInDB.add(userInDB);
            }
            else return null;
        }

        //确定UserOrgs
        Integer id =orgService.selectTheOrg(org).getId();
        List<UserOrg> userOrgs=new ArrayList<UserOrg>();
        for(int i=0;i<usersInDB.size();i++){
            UserOrg userOrg =new UserOrg();
            userOrg.setOrg_id(id);
            userOrg.setUser_id(usersInDB.get(i).getId());
            if(userOrgDao.selectTheUserOrg(userOrg)==null){
                userOrgs.add(userOrg);
            }
        }
        if(userOrgs.isEmpty()){
            return  null;
        }
        return userOrgs;
    }


    //User
    @Transactional
    public Object addUserWithOrgs(User user, List<Org> orgs) {

        //User 存在性检测
        User userInDB=userService.selectTheUser(user);
        if(userInDB!=null){
            return attenionMsg(userInDB.getLogin_name()+"  Exists Already");
        }

        //orgs 存在性检测
        List<Org> orgsInDB=new ArrayList<Org>();
        for(int i=0;i<orgs.size();i++){
            Org orgInDB =orgService.selectTheOrg(orgs.get(i));
            if(orgInDB!=null){
                orgsInDB.add(orgInDB);
            }
            else return attenionMsg("Orgs Not Exist");
        }

        Object objFir=userService.signUser(user);
        Integer id=userService.selectTheUser(user).getId();

        List<UserOrg> userOrgs=new ArrayList<UserOrg>();
        for(int i=0;i<orgsInDB.size();i++){
            UserOrg userOrg =new UserOrg();
            userOrg.setUser_id(id);
            userOrg.setOrg_id(orgsInDB.get(i).getId());
            if(userOrgDao.selectTheUserOrg(userOrg)==null){
                userOrgs.add(userOrg);
            }
        }
        if(userOrgs.isEmpty()){
            return attenionMsg("User In Those Orgs");
        }
        Object objSec=userOrgDao.insert(userOrgs);
        return result(objFir,objSec);
    }
    public Object callUserInOrgs(User user, List<Org> orgs) {

        List<UserOrg> userOrgs = confirmUserOrgsByUserOrgs(user,orgs);
        if(userOrgs!=null){
            return userOrgDao.insert(userOrgs);
        }
        else return attenionMsg("User、Orgs Not Exists Or UserOrgs Empty");
    }
    public Object callUserOffOrgs(User user, List<Org> orgs) {
        //User 存在性检测
        User userInDB=userService.selectTheUser(user);
        if(userInDB==null){
            return attenionMsg("User Not  Exists");
        }

        //orgs 存在性检测
        List<Org> orgsInDB=new ArrayList<Org>();
        for(int i=0;i<orgs.size();i++){
            Org orgInDB =orgService.selectTheOrg(orgs.get(i));
            if(orgInDB!=null){
                orgsInDB.add(orgInDB);
            }
            else return attenionMsg("Orgs Not Exist");
        }

        Integer id=userService.selectTheUser(user).getId();

        List<UserOrg> userOrgs=new ArrayList<UserOrg>();
        for(int i=0;i<orgsInDB.size();i++){
            UserOrg userOrg =new UserOrg();
            userOrg.setUser_id(id);
            userOrg.setOrg_id(orgsInDB.get(i).getId());
            if(userOrgDao.selectTheUserOrg(userOrg)!=null){
                userOrgs.add(userOrg);
            }
        }
        if(userOrgs.isEmpty()){
            return attenionMsg("User Not In Those Orgs");
        }
        return userOrgDao.delete(userOrgs);
    }
    @Transactional
    public Object deleteUserAndOrgs(User user) {
        User userInDB=userService.selectTheUser(user);
        if(userInDB==null){
            return attenionMsg("User Not  Exists");
        }
        else{
            Object objFir = userService.deleteUserById(userInDB.getId());
            Object objSec = userOrgDao.deleteAllOrgsByUserId(userInDB.getId());
            return result(objFir,objSec);
        }
    }
    public List<Org> getOrgsByUserId(Integer user_id) {
        return userOrgDao.selectOrgsByUserId(user_id);
    }


    //Org
    public Object addOrgWithUsers(Org org, List<User> users) {
        //org检测
        if(orgService.selectTheOrg(org)!=null){
            return attenionMsg("Org Exists Already");
        }

        //users 检测
        List<User> usersInDB = new ArrayList<User>();
        for(int i=0;i<users.size();i++){
            User userInDB=userService.selectTheUser(users.get(i));
            if(userInDB!=null){ //存在则暂存入memsInDB
                usersInDB.add(userInDB);
            }
            else return attenionMsg("Users Not Exist");
        }

        /*校验通过后完成新增*/
        Object objFir = orgService.insertOrg(org);
        Integer id =orgService.selectTheOrg(org).getId();

        List<UserOrg> userOrgs=new ArrayList<UserOrg>();
        for(int i=0;i<usersInDB.size();i++){
            UserOrg userOrg =new UserOrg();
            userOrg.setOrg_id(id);
            userOrg.setUser_id(usersInDB.get(i).getId());
            userOrgs.add(userOrg);
        }

        Object objSec = userOrgDao.insert(userOrgs);
        return result(objFir,objSec);
    }
    public Object addUsersToOrg(Org org, List<User> users) {
        List<UserOrg> userOrgs = confirmOrgUsersByOrgUsers(org,users);
        if(userOrgs!=null){
            return userOrgDao.insert(userOrgs);
        }
        else{
            return attenionMsg("Org,Users Not Exists org UserOrgs Empty");
        }
    }
    public Object deleteUsersFromOrg(Org org, List<User> users) {
        //org检测
        if(orgService.selectTheOrg(org)==null){
            return attenionMsg("Org Not Exists");
        }

        //users 检测
        List<User> usersInDB = new ArrayList<User>();
        for(int i=0;i<users.size();i++){
            User userInDB=userService.selectTheUser(users.get(i));
            if(userInDB!=null){ //存在则暂存入memsInDB
                usersInDB.add(userInDB);
            }
            else return attenionMsg("Users Not Exist");
        }

        /*校验通过后完成新增*/

        Integer id =orgService.selectTheOrg(org).getId();

        List<UserOrg> userOrgs=new ArrayList<UserOrg>();
        for(int i=0;i<usersInDB.size();i++){
            UserOrg userOrg =new UserOrg();
            userOrg.setOrg_id(id);
            userOrg.setUser_id(usersInDB.get(i).getId());
            if(userOrgDao.selectTheUserOrg(userOrg)!=null){
                userOrgs.add(userOrg);
            }
        }
        if(userOrgs.isEmpty()){
            return attenionMsg("Users Not In The Org");
        }
        return userOrgDao.delete(userOrgs);
    }
    public Object deleteOrgAndUsers(Org org) {
        Org orgInDB=orgService.selectTheOrg(org);
        if(orgInDB==null){
            return attenionMsg("Org Not  Exists");
        }
        else{
            Object objFir = orgService.deleteOrgById(orgInDB.getId());
            Object objSec = userOrgDao.deleteAllUsersByOrgId(orgInDB.getId());
            return result(objFir,objSec);
        }
    }
    public List<User> getUsersByOrgId(Integer org_id) {
        return userOrgDao.selectUsersByOrgId(org_id);
    }

    //userorg
    public Integer updateUserOrg(UserOrg userOrg) {
        return userOrgDao.updateWithId(userOrg);
    }
}
