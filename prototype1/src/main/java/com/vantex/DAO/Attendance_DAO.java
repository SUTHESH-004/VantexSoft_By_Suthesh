package com.vantex.DAO;

// import com.vantex.Model.AttendanceInfo;


import java.sql.Connection;
import java.sql.PreparedStatement;
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
    // public static ArrayList<EmployeeInfo> getAttendanceAndOutput(String Date) throws ClassNotFoundException, SQLException {
    //     Connection con = DbConnection.getConnection();

    //     String Query = "select * from"
    //     return null;
    // }
}
