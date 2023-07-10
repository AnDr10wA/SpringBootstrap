package com.kata.security.web.security.web.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, roles);
    }
}
