package com.kata.security.web.security.web.security;

import org.springframework.security.core.GrantedAuthority;
import com.kata.security.web.security.web.model.Role;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class RoleAuthority implements GrantedAuthority {

    private Role role;

    public RoleAuthority(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String getAuthority() {
        return role.getName();
    }
}