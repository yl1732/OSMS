package uosm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uosm.model.Admin;
import uosm.service.AdminService;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/signAdmin",method = RequestMethod.POST)
    public Object signAdmin(@RequestBody @Valid Admin admin,Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return adminService.signAdmin(admin);
    }

    @RequestMapping(value = "/loginAdmin",method = RequestMethod.POST)
    public Object loginAdmin(@RequestBody @Valid Admin admin,Errors errors){
        if(errors.hasErrors()){
            return errors.getFieldErrors();
        }
        return adminService.loginAdmin(admin);
    }

    @RequestMapping(value = "/selectAdminById",method = RequestMethod.POST)
    public Admin selectAdminById(@RequestBody Integer id){
        return adminService.selectAdminById(id);
    }

    @RequestMapping(value = "/selectAdminByName",method = RequestMethod.POST)
    public Admin selectAdminByName(@RequestBody String name){
        return adminService.selectAdminByName(name);
    }

    @RequestMapping(value = "/selectTheAdmin",method = RequestMethod.POST)
    public Admin selectAdminByName(@RequestBody Admin admin){
        return adminService.selectTheAdmin(admin);
    }

    @RequestMapping(value = "/selectAdmins",method = RequestMethod.POST)
    public Object selectAdmins(@RequestBody Admin admin){
        return adminService.selectAdmins(admin);
    }

    @RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
    public Object updateAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }

    @RequestMapping(value = "/deleteAdminById",method = RequestMethod.POST)
    public Integer deleteAdminById(@RequestBody Integer id){
        return adminService.deleteAdminById(id);
    }

    @RequestMapping(value = "/deleteAdminByName",method = RequestMethod.POST)
    public Integer deleteAdminByName(@RequestBody String name){
        return adminService.deleteAdminByName(name);
    }

}
