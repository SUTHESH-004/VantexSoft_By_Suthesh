package com.vantex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.vantex.Modal.EmployeeInfo;
import com.vantex.Modal.UserCredentials;

public class Employee_DAO {
    public static int AuthenticatePassword(UserCredentials uc) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "select emp_name from employee where password_hash = ? and email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, uc.getPassword());
            ps.setString(2, uc.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return 1;
            else
                return -1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }

    }

    public static EmployeeInfo getEmployeeInfo(UserCredentials uc) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getConnection();
        String query = "select emp_name,roles,emp_id,team_id from employee where email=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, uc.getEmail());
        ResultSet rs = ps.executeQuery();
        rs.next();
        EmployeeInfo ei = new EmployeeInfo();
        ei.setName(rs.getString(1));
        ei.setRole(rs.getString(2));
        ei.setEmp_id(rs.getInt(3));
        ei.setTeam_id(rs.getInt(4));
        return ei;
    }

    public static ArrayList<EmployeeInfo> getEmployeeByTeamId(EmployeeInfo s)
            throws SQLException, ClassNotFoundException {
        String Query = "select emp_name,emp_id from employee where team_id = ?";
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setInt(1, s.getTeam_id());
        ResultSet rs = ps.executeQuery();
        ArrayList<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
        while (rs.next()) {
            EmployeeInfo temp = new EmployeeInfo();
            temp.setName(rs.getString(1));
            temp.setEmp_id(rs.getInt(2));
            list.add(temp);
        }
        return list;

    }

    public static void addEmployee(EmployeeInfo employeeToAdd) throws ClassNotFoundException, SQLException {

        String Query = "insert into employee (emp_name,email,password_hash,date_of_birth,roles)values(?,?,?,?,?)";

        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setString(1, employeeToAdd.getName());
        ps.setString(2, employeeToAdd.getEmail());
        ps.setString(3, employeeToAdd.getPassword());
        ps.setString(4, employeeToAdd.getDate());
        ps.setString(5, employeeToAdd.getRole());
        ps.executeUpdate();
    }

    public static void removeEmployee(EmployeeInfo employeeToRemove) throws ClassNotFoundException, SQLException {
        String Query = "delete from employee where email=?";
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setString(1, employeeToRemove.getEmail());
        ps.executeUpdate();
    }

    public static ArrayList<EmployeeInfo> getAllEmployeeDetails() {
        String Query = "select emp_name, email,date_of_birth,roles from employee";
        ArrayList<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmployeeInfo ei = new EmployeeInfo();
                ei.setName(rs.getString(1));
                ei.setEmail(rs.getString(2));
                ei.setDateOfbirth(rs.getString(3));
                ei.setRole(rs.getString(4));
                list.add(ei);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}