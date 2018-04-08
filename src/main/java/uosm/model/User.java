package uosm.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Des User
 * @Name osms.model.User;
 * @Author Seakeer;
 * @Date 2018/3/16;
 * @Cpr Seakeer;
 * @Other
 */

public class User implements Serializable{

    @Min(value = 1,message = "User.id >= 1")
    private Integer id;  //id

    @NotNull(message = "User.login_name must not be null")
    @NotBlank(message = "User.login_name must not be blank")
    private String login_name; //用户名

    @NotNull(message = "User.pwd must not be null")
    @NotBlank(message = "User.pwd must not be blank")
    private String pwd;  //密码


    private String name; //姓名
    private String nick; //昵称
    private String sex;
    private String email;
    private String tel;
    private String phone;

    private List<Org> orgs;

    //无参构造函数
    public User(){
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

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }
    public String getLogin_name() {
        return login_name;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    public String getPwd(){
        return pwd;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setNick(String nick){
        this.nick = nick;
    }
    public String getNick(){
        return nick;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getTel() {
        return tel;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }


    public void setOrgs(List<Org> orgs) {
        this.orgs = orgs;
    }
    public List<Org> getOrgs() {
        return orgs;
    }

}
