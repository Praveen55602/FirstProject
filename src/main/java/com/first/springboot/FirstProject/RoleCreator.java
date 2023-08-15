package com.first.springboot.FirstProject;

import org.springframework.stereotype.Component;

@Component
public class RoleCreator implements Creator {
    public String create() {
        return "new role created successfully";
    }
}
