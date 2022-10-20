package dev.chambers.entities;

import java.util.Arrays;

public class Employee extends User{
    int pendingReimbursements;
    int awardedReimbursements;
    boolean isManager;

    public Employee(){};

    public Employee(int user_id, String email, String pass, String name, int pendingReimbursements, int awardedReimbursements, boolean isManager) {
        super(user_id, email, pass, name);
        this.pendingReimbursements = pendingReimbursements;
        this.awardedReimbursements = awardedReimbursements;
        this.isManager= isManager;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public int getPendingReimbursements() {
        return pendingReimbursements;
    }

    public void setPendingReimbursements(int pendingReimbursements) {
        this.pendingReimbursements = pendingReimbursements;
    }

    public int getAwardedReimbursements() {
        return awardedReimbursements;
    }

    public void setAwardedReimbursements(int awardedReimbursements) {
        this.awardedReimbursements = awardedReimbursements;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "pendingReimbursements=" + pendingReimbursements +
                ", awardedReimbursements=" + awardedReimbursements +
                ", isManager=" + isManager +
                ", user_id=" + user_id +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
