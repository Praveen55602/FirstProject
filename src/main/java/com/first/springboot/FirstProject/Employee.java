package com.first.springboot.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myEmployee") // we can give custom name
@Scope(value = "prototype") // this tells spring that it's not a singleton class
public class Employee {
    // if both the employee class and empCreator class are marked as component then
    // when I'll ask the srping for an object of employee then this will
    // automatically inject the empCreator object as that will be required for this
    // object's creation
    @Autowired
    @Qualifier("EmployeeCreator") // since there are two classes implementing creator interface we need to use
                                  // qualifier to tell which one should be used here
    Creator beanDependencyExample; // we'll not initialize it as it will be auto initialized by the spring boot

    public void runExaple() {
        System.out.println(beanDependencyExample.create());
    }
}
