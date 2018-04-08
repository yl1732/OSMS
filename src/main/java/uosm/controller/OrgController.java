package uosm.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uosm.model.Org;
import uosm.service.OrgService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrgController {
    @Autowired
    private OrgService orgService;

    @RequestMapping(value = "/insertOrg",method = RequestMethod.POST)
    public Object insertOrg(@RequestBody @Valid Org org, Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return orgService.insertOrg(org);
    }

    @RequestMapping(value = "/selectOrgById",method = RequestMethod.POST)
    public Org selectOrgById(@RequestBody Integer id){
        return orgService.selectOrgById(id);
    }

    @RequestMapping(value = "/selectTheOrg",method = RequestMethod.POST)
    public Org selectTheOrg(@RequestBody Org org){
        return orgService.selectTheOrg(org);
    }

    @RequestMapping(value = "/selectOrgs",method = RequestMethod.POST)
    public List<Org> selectOrgs(@RequestBody Org org){
        return orgService.selectOrgs(org);
    }

    @RequestMapping(value = "/selectLowerOrgsById",method = RequestMethod.POST)
    public List<Org> selectLowerOrgsById(@RequestBody Integer id){
        return orgService.selectLowerOrgsById(id);
    }

    @RequestMapping(value = "/selectAllLowerOrgs",method = RequestMethod.POST)
    public Object selectAllLowerOrgs(@RequestBody Org org){
        return orgService.selectAllLowerOrgs(org);
    }

    @RequestMapping(value = "/updateOrg",method = RequestMethod.POST)
    public Integer updateOrgWithId(@RequestBody Org org){
        return orgService.updateOrgWithId(org);
    }

    @RequestMapping(value = "/deleteOrgById",method = RequestMethod.POST)
    Integer deleteOrgById(@RequestBody Integer id){
        return orgService.deleteOrgById(id);
    }

}
