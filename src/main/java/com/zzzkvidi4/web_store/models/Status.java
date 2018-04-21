package com.zzzkvidi4.web_store.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "statuses", schema = "web_store")
public class Status {
    @Id
    @Column(name = "status_id")
    private int statusId;

    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    private String displayName;

    @OneToMany(mappedBy = "status")
    private Set<Order> orders;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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

        Status status = (Status) o;

        if (statusId != status.statusId) return false;
        if (name != null ? !name.equals(status.name) : status.name != null) return false;
        return displayName != null ? displayName.equals(status.displayName) : status.displayName == null;
    }

    @Override
    public int hashCode() {
        int result = statusId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        return result;
    }
}
