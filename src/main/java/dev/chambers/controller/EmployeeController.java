package dev.chambers.controller;


import dev.chambers.entities.Employee;
import dev.chambers.service.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){this.employeeService=employeeService;}

    public void updateEmployee(Context ctx){
        Employee e = ctx.bodyAsClass(Employee.class);
        employeeService.updateEmployee(e);
        ctx.status(HttpCode.NO_CONTENT);
    }
    public void updatePendingReimbursement(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("user_id"));
        double demandedReimbursement = Double.parseDouble(ctx.pathParam("pendingReimbursement"));
        employeeService.updatePendingReimbursement(id,demandedReimbursement);
        ctx.status(HttpCode.NO_CONTENT);

    }

    public void getEmployeeById(Context ctx){

        int id = Integer.parseInt(ctx.pathParam("user_id"));

        ctx.status(200);
        ctx.json(employeeService.getEmployeeById(id));
    }
    public void deleteEmployee(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("user_id"));
        employeeService.deleteEmployee(id);
    }

}
