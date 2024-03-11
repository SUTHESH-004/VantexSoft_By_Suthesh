package com.vantex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vantex.Model.EmployeeInfo;
import com.vantex.Model.UserCredentials;


public class Employee_DAO {
    public static int  AuthenticatePassword(UserCredentials uc)
    {
        try{
        Connection con = DbConnection.getConnection();
        String query = "select emp_name from employee where password_hash = ? and email=?"; 
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,uc.getPassword());
        ps.setString(2,uc.getEmail());
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            return 1;
        else
            return -1;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }

    }
    public static  EmployeeInfo getEmployeeRole(UserCredentials uc) throws SQLException, ClassNotFoundException
    {
            Connection con = DbConnection.getConnection();
            String query = "select emp_name,roles from employee where email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,uc.getEmail());
            ResultSet rs= ps.executeQuery();
            rs.next();
            EmployeeInfo ei = new EmployeeInfo();
            ei.setName(rs.getString(1));
            ei.setRole(rs.getString(2));
            return ei;
    }
}
