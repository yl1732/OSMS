package uosm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uosm.dao.OrgDao;
import uosm.model.Org;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orgService")
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgDao orgDao;

    public Map<String,String> attenionMsg(String msg){
        Map<String,String> map = new HashMap<String, String>();
        map.put("msg",msg);
        return  map;
    }

    @Transactional
    public Object insertOrg(Org org) {
        if(orgDao.selectTheOrg(org)!=null){
            return attenionMsg("Org Exists Already");
        }
        else{
            orgDao.insert(org);
            return orgDao.selectTheOrg(org);
        }
    }

    public Org selectOrgById(Integer id) {
        return orgDao.selectById(id);
    }

    public Org selectTheOrg(Org org) {
        return orgDao.selectTheOrg(org);
    }

    public List<Org> selectOrgs(Org org) {
        return orgDao.select(org);
    }

    public List<Org> selectLowerOrgsById(Integer id) {
        return orgDao.selectLowerOrgsById(id);
    }

    public Object selectAllLowerOrgs(Org org){
        Org orgInDB = orgDao.selectTheOrg(org);
        if(orgInDB==null){
            return attenionMsg("Org Not Exists");
        }
        else if(orgInDB.getPath()!=null){
            return orgDao.selectAllLowerOrgs(orgInDB);
        }
        else return attenionMsg("No Lower Orgs");

    }

    public Integer updateOrgWithId(Org org) {
        return orgDao.updateWithId(org);
    }

    public Integer deleteOrgById(Integer id) {
        return orgDao.deleteById(id);
    }

}
