package dev.chambers.dao;

import dev.chambers.entities.Employee;
import dev.chambers.entities.Request;
import dev.chambers.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {
    public Request submitRequest(Request request, Employee employee){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql ="insert into ers.requests values (default, ?, 1, null, false, ?, ?, ?, ?, ?, ?, ?, null, CURRENT_TIMESTAMP)";

            PreparedStatement ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, employee.getId());
            ps.setTimestamp(2,request.getEventDate());
            ps.setString(3, request.getEventDescription());
            ps.setString(4,request.getEmployeeJustification());
            ps.setInt(5, request.getEventType());
            ps.setDouble(6,request.getEventAmount());
            ps.setInt(7, request.getGradingFormat());
            ps.setString(8, request.getGradingCutoff());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                request.setCaseID(rs.getInt(1));
                return request;
            }else{
                return new Request();
            }
        }catch(SQLException e){
            e.printStackTrace();
            return new Request();
        }

    }
    //needs read by user ID and get all
    public List<Request> getAllRequests(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from ers.requests order by case_status";
            //this allows managers to view requests sorted by status. Urgency will be calculated dynamically on page load
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            List<Request> requests = new ArrayList<>();
            while (rs.next()){
                Request request = new Request(
                        rs.getInt("case_id"),
                        rs.getInt("user_id"),
                        rs.getInt("case_status"),
                        rs.getString("manager_comments"),
                        rs.getBoolean("exceeds_available_funds"),
                        rs.getTimestamp("event_date"),
                        rs.getString("event_description"),
                        rs.getString("employee_justification"),
                        rs.getInt("event_type"),
                        rs.getDouble("event_amount"),
                        rs.getInt("grading_format"),
                        rs.getString("grading_cutoff"),
                        rs.getString("grade_recieved"), //sic
                        rs.getTimestamp("date_submitted")
                );
                requests.add(request);
            }return requests;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public Request getRequest(int id){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from ers.requests where case_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Request request = new Request(
                        rs.getInt("case_id"),
                        rs.getInt("user_id"),
                        rs.getInt("case_status"),
                        rs.getString("manager_comments"),
                        rs.getBoolean("exceeds_available_funds"),
                        rs.getTimestamp("event_date"),
                        rs.getString("event_description"),
                        rs.getString("employee_justification"),
                        rs.getInt("event_type"),
                        rs.getDouble("event_amount"),
                        rs.getInt("grading_format"),
                        rs.getString("grading_cutoff"),
                        rs.getString("grade_recieved"), //sic
                        rs.getTimestamp("date_submitted"));
                return request;
            }else return null;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public List<Request> getRequestByEmployee(int id){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from ers.requests where user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            List<Request> requests = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Request request = new Request(
                        rs.getInt("case_id"),
                        rs.getInt("user_id"),
                        rs.getInt("case_status"),
                        rs.getString("manager_comments"),
                        rs.getBoolean("exceeds_available_funds"),
                        rs.getTimestamp("event_date"),
                        rs.getString("event_description"),
                        rs.getString("employee_justification"),
                        rs.getInt("event_type"),
                        rs.getDouble("event_amount"),
                        rs.getInt("grading_format"),
                        rs.getString("grading_cutoff"),
                        rs.getString("grade_recieved"), //sic
                        rs.getTimestamp("date_submitted"));
                requests.add(request);
            }return requests;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public boolean updateRequest(Request request){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update ers.requests set case_status=?, manager_comments=?, exceeds_available_funds=?, event_amount=?, grade_recieved=? where case_id = ?"; //sic
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,request.getCaseStatus());
            ps.setString(2, request.getManagerComments());
            ps.setBoolean(3,request.isExceedsFunds());
            ps.setDouble(4,request.getEventAmount());
            ps.setString(5,request.getGradeReceived());
            ps.setInt(6,request.getCaseID());
            int rowCount = ps.executeUpdate();
            if (rowCount==1){
                return true;
            }else{
                return false;}
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteRequest(int id){
        String sql = "delete from ers.requests where case_id=?";
        try (Connection conn = ConnectionUtil.createConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    /*public static void main(String[] args) {
        RequestDAO rd = new RequestDAO();
        Employee e = new Employee(2,"john@corpo.org","john1234","Johnny Computer",0,400,false);
        Request req = new Request(2,2,1,"another test?",false,new Timestamp(1666290040),"a big test at school","for work",5,10.0,1,null,null,new Timestamp(1666199846));
        System.out.println(rd.updateRequest(req));
    }*/
}