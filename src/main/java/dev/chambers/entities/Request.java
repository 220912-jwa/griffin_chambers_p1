package dev.chambers.entities;

import dev.chambers.dao.RequestDAO;

import java.sql.Timestamp;

public class Request {
    private int caseID;
    private int id;
    private int caseStatus; //should be enum
    private String managerComments;
    private boolean exceedsFunds;
    private Timestamp eventDate;
    private String eventDescription;
    private String employeeJustification;
    //private EventType eventType;
    private int eventType; //should be enum
    private double eventAmount;
    private int gradingFormat; //should be enum
    private String gradingCutoff;
    private String gradeReceived;
    private Timestamp dateSubmitted;

   public Request(){};

    public Request(int caseID, int id, int caseStatus, String managerComments, boolean exceedsFunds, Timestamp eventDate, String eventDescription, String employeeJustification, int eventType, double eventAmount, int gradingFormat, String gradingCutoff, String gradeReceived, Timestamp dateSubmitted) {
        this.id=id;
        this.caseID = caseID;
        this.caseStatus = caseStatus;
        this.managerComments = managerComments;
        this.exceedsFunds = exceedsFunds;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.employeeJustification = employeeJustification;
        this.eventType = eventType;
        this.eventAmount = eventAmount;
        this.gradingFormat = gradingFormat;
        this.gradingCutoff = gradingCutoff;
        this.gradeReceived = gradeReceived;
        this.dateSubmitted = dateSubmitted;
    }
    public Request(int id, Timestamp eventDate, String eventDescription, String employeeJustification, int eventType, int eventAmount, int gradingFormat, String gradingCutoff){
        this.id=id;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.employeeJustification = employeeJustification;
        this.eventType = eventType;
        this.eventAmount = eventAmount;
        this.gradingFormat = gradingFormat;
        this.gradingCutoff = gradingCutoff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public int getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(int caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getManagerComments() {
        return managerComments;
    }

    public void setManagerComments(String managerComments) {
        this.managerComments = managerComments;
    }

    public boolean isExceedsFunds() {
        return exceedsFunds;
    }

    public void setExceedsFunds(boolean exceedsFunds) {
        this.exceedsFunds = exceedsFunds;
    }

    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEmployeeJustification() {
        return employeeJustification;
    }

    public void setEmployeeJustification(String employeeJustification) {
        this.employeeJustification = employeeJustification;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public double getEventAmount() {
        return eventAmount;
    }

    public void setEventAmount(double eventAmount) {
        this.eventAmount = eventAmount;
    }

    public int getGradingFormat() {
        return gradingFormat;
    }

    public void setGradingFormat(int gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public String getGradingCutoff() {
        return gradingCutoff;
    }

    public void setGradingCutoff(String gradingCutoff) {
        this.gradingCutoff = gradingCutoff;
    }

    public String getGradeReceived() {
        return gradeReceived;
    }

    public void setGradeReceived(String gradeReceived) {
        this.gradeReceived = gradeReceived;
    }

    public Timestamp getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Timestamp dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    @Override
    public String toString() {
        return "Request{" +
                "caseID=" + caseID +
                ", user_id=" + id +
                ", caseStatus=" + caseStatus +
                ", managerComments='" + managerComments + '\'' +
                ", exceedsFunds=" + exceedsFunds +
                ", eventDate=" + eventDate +
                ", eventDescription='" + eventDescription + '\'' +
                ", employeeJustification='" + employeeJustification + '\'' +
                ", eventType=" + eventType +
                ", eventAmount=" + eventAmount +
                ", gradingFormat=" + gradingFormat +
                ", gradingCutoff='" + gradingCutoff + '\'' +
                ", gradeReceived='" + gradeReceived + '\'' +
                ", dateSubmitted=" + dateSubmitted +
                '}';
    }
}
