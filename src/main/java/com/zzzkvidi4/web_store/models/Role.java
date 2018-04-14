package com.zzzkvidi4.web_store.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "web_store")
public class Role {
    @Id
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    private String displayName;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (roleId != role.roleId) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        return displayName != null ? displayName.equals(role.displayName) : role.displayName == null;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        return result;
    }
}
