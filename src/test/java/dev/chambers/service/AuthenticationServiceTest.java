package dev.chambers.service;

import dev.chambers.dao.EmployeeDAO;
import dev.chambers.entities.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.assertEquals;

public class AuthenticationServiceTest {
    private static AuthenticationService as;
    private static EmployeeDAO employeeDAO;
    @BeforeAll
    public static void setup(){
        employeeDAO= new EmployeeDAO();
        as = new AuthenticationService(employeeDAO);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/mock/mockEmployees.csv")
    public void authenticationTest(int user_id, String email, String pass){
        Employee e = as.login(email, pass);
        assertEquals(pass, e.getPass());
    }}
    //doesn't spoof employee data, needs to use real data
    //won't get correct user ID for some reason, but employeeDAO does on its own
