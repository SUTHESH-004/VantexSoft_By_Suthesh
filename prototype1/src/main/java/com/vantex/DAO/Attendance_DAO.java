package com.vantex.DAO;

// import com.vantex.Model.AttendanceInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.vantex.Modal.EmployeeInfo;

public class Attendance_DAO {
    public static boolean markAttendance(ArrayList<EmployeeInfo> list, EmployeeInfo ei)
            throws SQLException, ClassNotFoundException {

        Connection con = DbConnection.getConnection();

        for (int i = 0; i < list.size(); i++) {
            String Query = "insert into attendance(employee_id,dateOfAttendance,status,attendant_id) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, list.get(i).getEmp_id());
            ps.setString(2, list.get(i).getDate());
            ps.setString(3, list.get(i).getStatus());
            ps.setInt(4, ei.getEmp_id());
            int rs = ps.executeUpdate();
            System.out.println(rs + "is Affected");

        }
        return true;

    }

    public static ArrayList<EmployeeInfo> getAttendanceAndOutput(String Date, EmployeeInfo ei)
            throws ClassNotFoundException, SQLException {
        Connection con = DbConnection.getConnection();
        String Query = "select e.emp_name,a.dateOfAttendance,a.status, d.output from attendance a join daily_output d on a.dateOfAttendance = d.dateOfOutput and a.employee_id = d.emp_id join employee e on e.emp_id=a.employee_id where dateOfOutput = ? and e.team_id = ?";
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setString(1, Date);
        ps.setInt(2, ei.getTeam_id());
        ResultSet rs = ps.executeQuery();
        ArrayList<EmployeeInfo> s = new ArrayList<EmployeeInfo>();
        while (rs.next()) {
            EmployeeInfo e = new EmployeeInfo();
            e.setName(rs.getString(1));
            e.setDate(rs.getString(2));
            e.setStatus(rs.getString(3));
            e.setOutput(rs.getInt(4));
            s.add(e);
            // System.out.println();nkjnkjkjnkjnknkj
        }
        return s;
    }

    public static ArrayList<EmployeeInfo> getAttendance(String Date, EmployeeInfo ei)
            throws ClassNotFoundException, SQLException {
        String Query = "select e.emp_name,a.status from employee e join attendance a on e.emp_id = a.employee_id where dateOfAttendance = ?";
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setString(1, Date);
        ResultSet rs = ps.executeQuery();
        ArrayList<EmployeeInfo> e = new ArrayList<EmployeeInfo>();
        while (rs.next()) {
            EmployeeInfo s = new EmployeeInfo();
            s.setName(rs.getString(1));
            s.setStatus(rs.getString(2));
            e.add(s);
        }
        return e;

    }

    public static ArrayList<EmployeeInfo> getOutput(String Date, EmployeeInfo ei)
            throws SQLException, ClassNotFoundException {
        String Query = "select e.emp_name,d.output from employee e join daily_Output d on e.emp_id=d.emp_id where dateOfoutput=?";
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setString(1, Date);
        ResultSet rs = ps.executeQuery();
        ArrayList<EmployeeInfo> s = new ArrayList<EmployeeInfo>();
        while (rs.next()) {
            EmployeeInfo tempei = new EmployeeInfo();
            tempei.setName(rs.getString(1));
            tempei.setOutput(rs.getInt(2));
            s.add(tempei);
        }
        return s;

        // return null;
    }

}
