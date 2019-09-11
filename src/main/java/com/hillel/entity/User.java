package com.hillel.entity;

public class User extends Entity {
    private String password;
    private Role role;

    public User(int id, String name, String password, Role role) {
        super(id, name);

        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                "password='" + getPassword() + '\'' +
                ", role=" + getRole() +
                '}';
    }
}
