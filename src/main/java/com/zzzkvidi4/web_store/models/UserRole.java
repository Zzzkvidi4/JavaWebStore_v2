package com.zzzkvidi4.web_store.models;

import javax.persistence.*;

@Entity
@Table(name = "user_roles", schema = "web_store")
@IdClass(UserRolePK.class)
public class UserRole {

    @Id
    @Column(name = "role_id")
    private int roleId;

    @Id
    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


}
