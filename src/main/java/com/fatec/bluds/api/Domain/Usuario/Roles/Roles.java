package com.fatec.bluds.api.Domain.Usuario.Roles;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    GUEST("Guest"),
    USER("User"),
    ADMIN("Admin");

    public String roleName;

    Roles(String roleName) {
    }

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
