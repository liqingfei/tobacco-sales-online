package com.tobacco.sales.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "user")
public class UserDTO {

    @XmlAttribute
    private String username;
    @XmlElement
    private List<String> roles;
    @XmlElement
    private Map<String, String> attributes;

    public UserDTO(String username, List<String> roles, Map<String, String> attributes) {
        this.username = username;
        this.roles = roles;
        this.attributes = attributes;
    }
}
