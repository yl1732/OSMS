package uosm.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Des Admin
 * @Name osms.model.Admin;
 * @Author Seakeer;
 * @Date 2018/3/16;
 * @Cpr Seakeer;
 * @Other
 */
public class Admin implements Serializable{

    @Min(value = 1,message = "Admin.id >=1")
    private Integer id;  //id

    @NotNull(message = "Admin.name must not be null ")
    @NotBlank(message = "Admin.name must nuot be blank")
    private String name; //用户名

    @NotNull(message = "Admin.pwd must not be null ")
    @NotBlank(message = "Admin.pwd must nuot be blank")
    private String pwd;  //密码

    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "Admin.email format error")
    private String email; //邮件

    //无参构造函数
    public Admin(){
        super();
    }

    /*
    setter and getter
     */
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    public String getPwd(){
        return pwd;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

}
