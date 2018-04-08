package uosm.dao;

import org.apache.ibatis.annotations.*;
import uosm.model.Admin;

import java.util.List;

/**
 * @Des AdminDao
 * @Name uosm.dao.AdminDao;
 * @Author Seakeer;
 * @Date 2018/3/16;
 * @Cpr Seakeer;
 * @Other itf
 */
public interface AdminDao {

    Integer insert(@Param("admin") Admin admin);
    Admin selectById(Integer id);
    Admin selectByName(String name);
    Admin selectByNailAndPwd(Admin admin);
    Admin selectTheAdmin(Admin admin);
    List<Admin> select(Admin admin);
    Integer updateWithId(Admin admin);
    Integer deleteById(Integer id);
    Integer deleteByName(String name);
}
