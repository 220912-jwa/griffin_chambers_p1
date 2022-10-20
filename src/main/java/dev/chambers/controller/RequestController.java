package dev.chambers.controller;

import dev.chambers.entities.Employee;
import dev.chambers.entities.Request;
import dev.chambers.service.RequestService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;

import java.util.List;

public class RequestController {
    private RequestService requestService;
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }
    public void createRequest(Context ctx){
        Request request = ctx.bodyAsClass(Request.class);
        Employee employee = ctx.bodyAsClass(Employee.class);
        Request newRequest = requestService.createNewRequest(request, employee);
        ctx.status(HttpCode.CREATED);
        ctx.json(newRequest);
    }
    public void createNewRequest(Context ctx){
        Request request = ctx.bodyAsClass(Request.class);
    }
    public void getAllRequestsByEmployee(Context ctx){
        ctx.status(200);
        ctx.json(requestService.getRequestByEmployee(Integer.parseInt(ctx.pathParam("user_id"))));

    }
    public void getAllRequests(Context ctx){
        List<Request> requests = requestService.getAllRequests();
        ctx.status(200);
        ctx.json(requests);
    }
    public void updateRequest(Context ctx){
        Request request = ctx.bodyAsClass(Request.class);
        requestService.updateRequest(request);
        ctx.status(HttpCode.NO_CONTENT);
    }
    public void deleteRequest(Context ctx){
        int id =Integer.parseInt(ctx.pathParam("case_id"));
        requestService.deleteRequest(id);
        ctx.status(HttpCode.NO_CONTENT);
    }
    public void getRequest(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("case_id"));
        Request request = requestService.getRequest(id);
        ctx.status(200);
        ctx.json(request);
    }
}
