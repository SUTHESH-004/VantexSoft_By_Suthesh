package com.vantex.Controller;
import com.vantex.view.*;

import java.sql.SQLException;

import com.vantex.DAO.*;
import com.vantex.Model.*;
public class App {
    public static void start() throws ClassNotFoundException, SQLException
    {
        UserCredentials uc = ConsoleUI.Loginview();
        int flag = Employee_DAO.AuthenticatePassword(uc);
        if(flag==1)
        {
            System.out.println("The Password is correct");
        }
        else
        {
            start();
        }
        EmployeeInfo ei = Employee_DAO.getEmployeeRole(uc);
        switch(ei.getRole()){
        case "Manager":{
            System.out.println("Welcome, Manager "+ei.getName());
            ManagerController.start();
            break;
        }
        case "Supervisor":{
            System.out.print("Welcome, Supervisor "+ ei.getName());
            SupercisorController.start(ei);
            break;
                }
        case "Employee":{
            System.out.print("Welcome,"+ei.getName());
            EmployeeController.start();
        }
        }




        
    }
}
