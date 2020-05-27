package cn.cuit.gyl.domain.privilege;

import java.util.List;

//权限当角色使用
public class Permission {

    private Integer id;//权限id
    private String permission_name;//当角色用
    private String permission_desc;//权限描述

    //多表关系
    private List<Role> roles;//角色

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permission_name='" + permission_name + '\'' +
                ", permission_desc='" + permission_desc + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public String getPermission_desc() {
        return permission_desc;
    }

    public void setPermission_desc(String permission_desc) {
        this.permission_desc = permission_desc;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
