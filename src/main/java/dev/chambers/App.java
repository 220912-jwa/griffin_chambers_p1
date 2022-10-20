package dev.chambers;

import dev.chambers.controller.AuthenticationController;
import dev.chambers.controller.EmployeeController;
import dev.chambers.controller.RequestController;
import dev.chambers.dao.EmployeeDAO;
import dev.chambers.dao.RequestDAO;
import dev.chambers.service.AuthenticationService;
import dev.chambers.service.EmployeeService;
import dev.chambers.service.RequestService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        RequestDAO requestDAO = new RequestDAO();

        EmployeeService employeeService = new EmployeeService(employeeDAO,requestDAO);
        RequestService requestService = new RequestService(requestDAO);

        RequestController rc = new RequestController(requestService);
        EmployeeController ec = new EmployeeController(employeeService);

        AuthenticationController ac = new AuthenticationController(new AuthenticationService(new EmployeeDAO()));

        Javalin app = Javalin.create(config -> {
                    config.enableCorsForAllOrigins();
                    config.addStaticFiles("/public", Location.CLASSPATH);
                }
        ).start(8080);

        app.routes(() -> {
            path("/authenticate", () -> {
                post(ac.login);
            });


            path("/{user_id}", () -> {
                //get(ec::getEmployeeById);
                put(ec::updateEmployee);
                delete(ec::deleteEmployee);


            });
            path("/{user_id}/requests",() ->{
                //this is for employees
                post(rc::createRequest);
                get(rc::getAllRequestsByEmployee);
                //put(ec::updatePendingReimbursement);

            });

            path("/requests",() ->{
                //this is only for managers
                get(rc::getAllRequests);
                post(rc::createRequest);
                path("/{case_id}",() ->{
                    //this is for case detail pages
                    get(rc::getRequest);
                    put(rc::updateRequest);
                    delete(rc::deleteRequest);

                });
            });

        });

        app.get("/getSession", ctx -> {
            if (ctx.sessionAttribute("loggedInEmployee") != null) {
                ctx.json(ctx.sessionAttribute("loggedInEmployee"));
            } else {
                ctx.json("no one is logged in");
            }

        });




}}
