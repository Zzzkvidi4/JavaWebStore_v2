package com.zzzkvidi4.web_store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
@Table(name = "user_roles", schema = "web_store")
@IdClass(UserRolePK.class)
@JsonIgnoreType
public class UserRole {

    @Id
    @Column(name = "role_id")
    @JsonIgnore
    private int roleId;

    @Id
    @Column(name = "user_id")
    @JsonIgnore
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, updatable = false, insertable = false)
    @JsonUnwrapped
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (roleId != userRole.roleId) return false;
        return userId == userRole.userId;

    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + userId;
        return result;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
