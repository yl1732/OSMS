package uosm.model;

import java.io.Serializable;

public class UserOrg implements Serializable{
    private Integer id;
    private Integer user_id;
    private Integer org_id;

    public UserOrg(){
        super();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public Integer getUser_id() {
        return user_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }
    public Integer getOrg_id() {
        return org_id;
    }
}
