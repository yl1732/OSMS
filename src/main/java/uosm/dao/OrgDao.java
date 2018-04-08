package uosm.dao;


import uosm.model.Org;

import java.util.List;


/**
 * @Des OrgDao
 * @Name uosm.dao.OrgDao;
 * @Author Seakeer;
 * @Date 2018/3/19;
 * @Cpr Seakeer;
 * @Other Itf;
 */
public interface OrgDao {

    Integer insert(Org org); //增加;
    Org selectById(Integer id);//根据Id查询
    Org selectTheOrg(Org org);
    List<Org> select(Org org); //动态查询
    List<Org> selectLowerOrgsById(Integer org_id);
    List<Org> selectAllLowerOrgs(Org org);
    Integer updateWithId(Org org); //修改；
    Integer deleteById(Integer id); //根据ID删除组织；
}
