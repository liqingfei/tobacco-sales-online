package com.tobacco.sales.security;

import com.tobacco.sales.dao.UserDaoImpl;
import com.tobacco.sales.entity.Role;
import com.tobacco.sales.entity.UserAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDaoImpl userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.tobacco.sales.entity.User user = userDao.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
        List<Role> roles = userDao.findRolesWithUser(username);
        List<UserAttr> attributes = userDao.findAttrsWithUser(username);

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Map<String, String> attrs = new HashMap<String, String>();

        if (roles != null && roles.size() >0) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRolename()));
            }
        }

        if (attributes != null && attributes.size() > 0) {
            for (UserAttr attr : attributes) {
                attrs.put(attr.getName(), attr.getValue());
            }
        }

        UserPrincipal userDetails = new UserPrincipal(user.getUsername(), user.getPassword(), authorities, attrs);

        return userDetails;
    }
}
