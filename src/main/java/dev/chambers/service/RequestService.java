package dev.chambers.service;

import dev.chambers.dao.RequestDAO;
import dev.chambers.entities.Employee;
import dev.chambers.entities.EventType;
import dev.chambers.entities.Request;

import java.util.List;

public class RequestService {
    private RequestDAO requestDAO;

    public RequestService(RequestDAO requestDAO){
        this.requestDAO=requestDAO;
    }

    public Request createNewRequest(Request request, Employee employee){
        return requestDAO.submitRequest(request, employee);
    }
    public Request submitRequest(Request request, Employee employee){
        return requestDAO.submitRequest(request, employee);
    }
    public List<Request> getRequestByEmployee(int id){
        return requestDAO.getRequestByEmployee(id);
    }
    public List<Request> getAllRequests(){
        return requestDAO.getAllRequests();
    }
    public void updateRequest(Request request){
        requestDAO.updateRequest(request);
    }
    public void deleteRequest(int id){
        requestDAO.deleteRequest(id);
    }
    public Request getRequest(int id){
        return requestDAO.getRequest(id);
    }


    public static int getEventTypeInt(EventType eventType){
        int eventID = 0;
        switch (eventType){
            case UNIVERSITY_COURSE: eventID = 1; break;
            case SEMINAR: eventID = 2; break;
            case CERTIFICATION_PREPARATION_CLASS: eventID = 3; break;
            case CERTIFICATION: eventID = 4; break;
            case TECHNICAL_TRAINING: eventID = 5; break;
            case OTHER: eventID = 6; break;
        }
        return eventID;
//return eventType.ordinal()
    }
}
