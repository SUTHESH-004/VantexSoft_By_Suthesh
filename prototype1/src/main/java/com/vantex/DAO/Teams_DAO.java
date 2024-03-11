package com.vantex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vantex.Model.EmployeeInfo;

public class Teams_DAO {
    

    public static EmployeeInfo getEmployeeTeamId(EmployeeInfo ei) throws SQLException, ClassNotFoundException    
    {

        Connection con = DbConnection.getConnection();
        String Query = "select team_id , team_name from teams where supervisor_id =?";
        PreparedStatement ps = con.prepareStatement(Query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        EmployeeInfo su = new EmployeeInfo();
        su.setEmp_id(rs.getInt(1));
        su.setTeam_name(rs.getString(2));
        return su;
    }



}
