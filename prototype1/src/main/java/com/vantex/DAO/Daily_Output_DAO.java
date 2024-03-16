package com.vantex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vantex.Modal.EmployeeInfo;


public class Daily_Output_DAO {
    public static ArrayList<EmployeeInfo> markOutput(ArrayList<EmployeeInfo> list, EmployeeInfo ei)
            throws ClassNotFoundException, SQLException {
        Connection con = DbConnection.getConnection();
        for (int i = 0; i < list.size(); i++) {
            String Query = "insert into daily_output (emp_id,output,dateOfOutput,supervisor_id) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, list.get(i).getEmp_id());
            ps.setDouble(2, list.get(i).getOutput());
            ps.setString(3, list.get(i).getDate());
            ps.setInt(4, ei.getEmp_id());
            int r = ps.executeUpdate();
            System.out.println("rows affected =" + r);

        }
        return list;
    }

}
