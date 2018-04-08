package uosm.service;

import uosm.model.Admin;

import java.util.List;

public interface AdminService {

    Object signAdmin(Admin admin);
    Object loginAdmin(Admin admin);
    Admin selectAdminById(Integer id);
    Admin selectAdminByName(String name);
    Admin selectTheAdmin(Admin admin);
    List<Admin> selectAdmins(Admin admin);
    Object updateAdmin(Admin admin);
    Integer deleteAdminById(Integer id);
    Integer deleteAdminByName(String name);

}
