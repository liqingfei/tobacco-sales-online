package com.tobacco.sales.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Map;

public class UserPrincipal extends User {

    private Map<String, String> attributes;

    public UserPrincipal(String username, String password, Collection<? extends GrantedAuthority> authorities, Map<String, String> attributes) {
        super(username, password, authorities);
        this.attributes = attributes;
    }

    public UserPrincipal(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Map<String, String> attributes) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.attributes = attributes;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
