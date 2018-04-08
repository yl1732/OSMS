package uosm.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Des 组织实体类；
 * @Name osms.model.Org;
 * @Author Seakeer;
 * @Date 2018/3/19;
 * @Cpr Seakeer;
 * @Other 
 */
public class Org implements Serializable{

    @Min(value = 1,message = "Org.id > =1")
    private Integer id;

    @NotNull(message = "Org.name must not be null")
    @NotBlank(message = "Org.name must not be blank")
    private String name;

    @Min(value = 1,message = "Org.suporg > =1")
    private Integer suporg;

    @NotNull(message = "Org.path must not be null")
    private String path;

    private List<User> users;

    public Org() {
        super();
    }

    /*setter and getter*/
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSuporg(Integer suporg) {
        this.suporg = suporg;
    }
    public Integer getSuporg() {
        return suporg;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<User> getUsers() {
        return users;
    }

}
