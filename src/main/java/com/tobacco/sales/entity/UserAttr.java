package com.tobacco.sales.entity;

public class UserAttr {

    private String username;
    private String name;
    private String value;
    private long updated;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

        UserAttr userAttr = (UserAttr) o;

        if (username != null ? !username.equals(userAttr.username) : userAttr.username != null) return false;
        return name != null ? name.equals(userAttr.name) : userAttr.name == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserAttr{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", updated=" + updated +
                '}';
    }
}
