package com.tobacco.sales.ws;

import com.tobacco.sales.dao.UserDaoImpl;
import com.tobacco.sales.dto.UserDTO;
import com.tobacco.sales.entity.Role;
import com.tobacco.sales.entity.User;
import com.tobacco.sales.entity.UserAttr;
import com.tobacco.sales.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/user")
@Consumes(value = "application/json")
@Produces(value = "application/json")
@Component
public class UserResource {

    @Autowired
    private UserDaoImpl userDao;

    @Path("/current")
    public UserDTO currentUser() {
        if (SecurityContextHolder.getContext().getAuthentication() != null  && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<String> roles = new ArrayList<String>();
            for (GrantedAuthority authority : principal.getAuthorities()) {
                roles.add(authority.getAuthority());
            }
            return new UserDTO(principal.getUsername(), roles, principal.getAttributes());
        } else {
            return null;
        }
    }

    @Path("/")
    @GET
    public List<UserDTO> getList() {
        List<User> list = userDao.getList();
        UserDTO dto;
        List<UserAttr> attrs;
        List<Role> roles;
        List<UserDTO> users = new ArrayList<UserDTO>();
        for (User user : list) {
            roles = userDao.findRolesWithUser(user.getUsername());
            attrs = userDao.findAttrsWithUser(user.getUsername());

            List<String> rlist = new ArrayList<String>();
            for (Role role : roles) {
                rlist.add(role.getRolename());
            }

            Map<String, String> aMap = new HashMap<String, String>();
            for (UserAttr attr : attrs) {
                aMap.put(attr.getName(), attr.getValue());
            }

            dto = new UserDTO(user.getUsername(), rlist, aMap);

            users.add(dto);
        }
        return users;
    }

}