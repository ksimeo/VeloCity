package model;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public class Role {
    private int roleId;
    private String nameRole;

    public Role(int roleId, String nameRole) {
        this.roleId = roleId;
        this.nameRole = nameRole;
    }

    public Role() {}

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
