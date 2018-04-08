package uosm.service;

import uosm.model.Org;

import java.util.List;

public interface OrgService {

    Object insertOrg(Org org);
    Org selectOrgById(Integer id);
    Org selectTheOrg(Org org);
    List<Org> selectOrgs(Org org);
    List<Org> selectLowerOrgsById(Integer id);
    Object selectAllLowerOrgs(Org org);
    Integer updateOrgWithId(Org org);
    Integer deleteOrgById(Integer id);

}
