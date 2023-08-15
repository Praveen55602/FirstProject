package com.first.springboot.FirstProject;

import org.springframework.stereotype.Component;

@Component("EmployeeCreator") // this makes it bean and by default will be singleton class
public class EmpCreator implements Creator {
    public String fetchCustomer(int count) {
        return " The no of customers fetched are : " + count;
    }

    public String create() {
        return "employee is successfully created";
    }

}
