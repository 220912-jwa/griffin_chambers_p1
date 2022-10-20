package dev.chambers.service;


import dev.chambers.dao.EmployeeDAO;
import dev.chambers.dao.RequestDAO;
import dev.chambers.entities.Employee;
import dev.chambers.entities.Request;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;
    private RequestDAO requestDAO;
    public EmployeeService(){};
    public EmployeeService(EmployeeDAO employeeDAO, RequestDAO requestDAO){
        this.employeeDAO=employeeDAO;
        this.requestDAO=requestDAO;
    }
    public Request submitRequest(Request request, Employee employee){
        return requestDAO.submitRequest(request, employee);
    }
    public List<Request> getRequestByEmployee(int id){
        return requestDAO.getRequestByEmployee(id);
    }
    public Employee getEmployeeById(int id){
        return employeeDAO.getEmployeeById(id);
    }
    public void updateEmployee(Employee e){
        employeeDAO.updateEmployee(e);
    }
    public void updatePendingReimbursement(int user_id, double demandedReimbursement){
        employeeDAO.updatePendingReimbursement(user_id,demandedReimbursement);
    }
    public void deleteEmployee(int id){
        employeeDAO.deleteEmployee(id);
    }

}
