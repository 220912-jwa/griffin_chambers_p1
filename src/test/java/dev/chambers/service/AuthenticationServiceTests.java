package dev.chambers.service;

import dev.chambers.dao.EmployeeDAO;
import dev.chambers.entities.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

    @ExtendWith(MockitoExtension.class)
    public class AuthenticationServiceTests {
    @InjectMocks
    private static AuthenticationService as;
    @Mock
    private static EmployeeDAO employeeDAO;
    private Employee mockRightEmailPassCombo;
    private Employee mockWrongCombo;

    @BeforeAll
        public static void setup(){}

    @BeforeEach
    public void mockObjects(){
        mockRightEmailPassCombo = new Employee(0,"g@corpo.org","password","JDoe",0,0,false);
    }

}
