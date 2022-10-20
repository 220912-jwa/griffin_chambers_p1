package dev.chambers.controller;

import dev.chambers.entities.Employee;
import dev.chambers.service.AuthenticationService;

import dev.chambers.service.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AuthenticationController {
    private AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService=authenticationService;
    }
    public Handler login = ctx ->{
        Employee e = ctx.bodyAsClass(Employee.class);
        Employee authenticatedEmployee = authenticationService.login(e.getEmail(),e.getPass());
        ctx.sessionAttribute("loggedInEmployee",authenticatedEmployee);/*
        ctx.sessionAttribute("isManager",e.isManager()) ;
        ctx.sessionAttribute("user_id",e.getId());
        ctx.sessionAttribute("isManager",e.isManager());*/
        if(authenticatedEmployee != null){
            ctx.status(200);
            ctx.json(authenticatedEmployee);
        }
    };

}
