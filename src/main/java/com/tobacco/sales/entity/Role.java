package com.tobacco.sales.entity;

public class Role {

    private String username;
    private String rolename;
    private long updated;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (username != null ? !username.equals(role.username) : role.username != null) return false;
        return rolename != null ? rolename.equals(role.rolename) : role.rolename == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "username='" + username + '\'' +
                ", rolename='" + rolename + '\'' +
                ", updated=" + updated +
                '}';
    }
}
