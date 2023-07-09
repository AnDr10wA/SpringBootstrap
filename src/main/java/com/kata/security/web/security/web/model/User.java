package com.kata.security.web.security.web.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public Collection<Role> getRoles() {
        return roles;
    }

    public String formatedRoles() {
        Collection<Role> userRoles = this.getRoles();
        if (userRoles.size() == 0) {
            return "NO ROLES";
        }
        return userRoles.toString().replaceAll("^\\[|\\]$", "");
    }


    public boolean isAdmin() {
        Collection<Role> userRoles = this.getRoles();
        return userRoles.stream().anyMatch(s -> s.getName().contains("ROLE_ADMIN"));
    }


    public boolean isUser() {
        Collection<Role> userRoles = this.getRoles();
        return userRoles.stream().anyMatch(s -> s.getName().contains("ROLE_USER"));
    }

}
