package dev.chambers.dao;

import dev.chambers.entities.Employee;
import dev.chambers.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeDAO {
//creates a new entry in employee table
    public Employee createEmployee(Employee employee){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql ="insert into ers.employees values (default, ?, ?, ?, 0, 0)";

            PreparedStatement ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getEmail());
            ps.setString(2, employee.getPass());
            ps.setString(3,employee.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                employee.setId(rs.getInt(1));
                return employee;
            }else{
                return new Employee();
            }
        }catch(SQLException e){
            e.printStackTrace();
            return new Employee();
        }
    }

//updates employee table to new values
    public boolean updateEmployee(Employee employee){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update ers.employees set email=?, pass=?, full_name=?, pending_reimbursements=?, awarded_reimbursements=?, is_manager=?, where user_id=?";
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,employee.getEmail());
            ps.setString(2,employee.getPass());
            ps.setString(3,employee.getName());
            ps.setInt(4,employee.getPendingReimbursements());
            ps.setInt(5,employee.getAwardedReimbursements());
            ps.setBoolean(6,employee.isManager());
            ps.setInt(7,employee.getId());
            int rowCount = ps.executeUpdate();
            if (rowCount==1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean updatePendingReimbursement(int user_id, double demandedReimbursement){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update ers.employees set pending_reimbursements=? where user_id=?";
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setInt(2,user_id);
            ps.setDouble(1,demandedReimbursement);
            int rowCount = ps.executeUpdate();
            if (rowCount==1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public Employee getEmployeeByEmail(String email){
        try (Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from ers.employees where email=?";
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Employee employee = new Employee(
                        rs.getInt("user_id"),
                        rs.getString("email"),
                        rs.getString("pass"),
                        rs.getString("full_name"),
                        rs.getInt("pending_reimbursements"),
                        rs.getInt("awarded_reimbursements"),
                        rs.getBoolean("is_manager")

                );

                return employee;

            }else{
                return new Employee();
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
    public Employee getEmployeeById(int id){
        try (Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from ers.employees where user_id=?";
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Employee employee = new Employee(
                        id,
                        rs.getString("email"),
                        rs.getString("pass"),
                        rs.getString("full_name"),
                        rs.getInt("pending_reimbursements"),
                        rs.getInt("awarded_reimbursements"),
                        rs.getBoolean("is_manager")

                );
                return employee;

            }else{
                return new Employee();
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public List<Employee> getAllEmployees(){
        try (Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from ers.employees";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            while (rs.next()){
                                Employee employee = new Employee(
                        rs.getInt("user_id"),
                        rs.getString("email"),
                        rs.getString("pass"),
                        rs.getString("full_name"),
                        rs.getInt("pending_reimbursements"),
                        rs.getInt("awarded_reimbursements"),
                        rs.getBoolean("is_manager")

                );
                employee.setId(rs.getInt("user_id"));
                employees.add(employee);
            }return employees;

        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean deleteEmployee(int id){
        try (Connection connection = ConnectionUtil.createConnection()) {
            String sql = "delete from ers.employees where user_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int rowcount = ps.executeUpdate();
            if (rowcount == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    /*public static void main(String[] args) {
        EmployeeDAO ed = new EmployeeDAO();
        System.out.println(ed.getAllEmployees());
    }*/



}
