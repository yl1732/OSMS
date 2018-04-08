package uosm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uosm.dao.AdminDao;
import uosm.model.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public Map<String,String> attenionMsg(String msg){
        Map<String,String> map = new HashMap<String, String>();
        map.put("msg",msg);
        return  map;
    }

    public Object signAdmin(Admin admin) {

        if(adminDao.selectByName(admin.getName())!=null){
            return attenionMsg("Sign Failed:Admin Exists Already");
        }
        else{
            adminDao.insert(admin);
            return adminDao.selectTheAdmin(admin);
        }
    }

    public Object loginAdmin(Admin admin) {
        Admin adminInDB = adminDao.selectByNailAndPwd(admin);
        if(adminInDB!=null){
            return adminInDB;
        }
        else return attenionMsg("Login Failed:Acount or Password Error");
    }

    public Admin selectAdminById(Integer id) {
        return adminDao.selectById(id);
    }

    public Admin selectAdminByName(String name) {
        return adminDao.selectByName(name);
    }

    public Admin selectTheAdmin(Admin admin) {
        return adminDao.selectTheAdmin(admin);
    }

    public List<Admin> selectAdmins(Admin admin) {
        return adminDao.select(admin);
    }

    public Object updateAdmin(Admin admin) {

        if(admin.getName()!=null&&adminDao.selectByName(admin.getName())!=null){
            return attenionMsg("Admin Exists Already ");
        }
        else{
            adminDao.updateWithId(admin);
            return adminDao.selectTheAdmin(admin);
        }

    }

    public Integer deleteAdminById(Integer id) {
        return adminDao.deleteById(id);
    }

    public Integer deleteAdminByName(String  name) {
        return adminDao.deleteByName(name);
    }
}
