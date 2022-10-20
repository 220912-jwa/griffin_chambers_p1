package dev.chambers.service;

import dev.chambers.dao.EmployeeDAO;
import dev.chambers.entities.Employee;

public class AuthenticationService {

    private EmployeeDAO employeeDAO;
    public AuthenticationService(EmployeeDAO employeeDAO) {this.employeeDAO=employeeDAO;}
    public Employee login (String email, String pass){
        Employee e = employeeDAO.getEmployeeByEmail(email);
        System.out.println(e);
        if(e.getPass().equals(pass)){
            System.out.println("Login Successful!");
            return e;
        }else{
            System.out.println("Login Failed. Please ensure you are entering the correct email and password");
            return null;
        }
    }


}
