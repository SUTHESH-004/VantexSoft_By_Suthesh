package com.vantex.view;

import com.vantex.Model.*;

import java.time.LocalDate;
import java.util.*;

public class ConsoleUI {
    static Scanner sc = Scan.getScanner();
    public static void welcomeDisplay() {
        System.out.printf("%30s", " ");
        System.out.print("__     __          _              ____         __ _                          \n");

        System.out.printf("%30s", " ");
        System.out.print("\\ \\   / /_ _ _ __ | |_ _____  __ / ___|  ___  / _| |___      ____ _ _ __ ___ \n");
        System.out.printf("%30s", " ");
        System.out.print(" \\ \\ / / _` | '_ \\| __/ _ \\ \\/ / \\___ \\ / _ \\| |_| __\\ \\ /\\ / / _` | '__/ _ \\\n");
        System.out.printf("%30s", " ");
        System.out.print("  \\ V / (_| | | | | ||  __/>  <   ___) | (_) |  _| |_ \\ V  V / (_| | | |  __/\n");
        System.out.printf("%30s", " ");
        System.out.print("   \\_/ \\__,_|_| |_|\\__\\___/_/\\_\\ |____/ \\___/|_|  \\__| \\_/\\_/ \\__,_|_|  \\___|");
    }
    public static UserCredentials Loginview() {
        UserCredentials idpass = new UserCredentials();
        System.out.println("Enter your Email : ");
        idpass.setEmail(sc.nextLine());
        System.out.println("Enter you password : ");
        idpass.setPassword(sc.nextLine());
        return idpass;
    }
    public static Choice ContinueOrExit()
    {
        Choice S = new Choice();
        System.out.print("do want to continue or exit");
        S.setChoice(sc.nextInt());
        return S;
    }
    public ArrayList<EmployeeInfo> putAttendance(ArrayList<EmployeeInfo> listEmp )
    {
        LocalDate date = LocalDate.now();
        for(int i=0;i<listEmp.size();i++)
        {

            System.out.println(listEmp.get(i).getName());

            listEmp.get(i).setStatus(sc.next());
            listEmp.get(i).setDate(date+"");
        }
        return listEmp;
    }
    public ArrayList<EmployeeInfo> putOutput(ArrayList<EmployeeInfo>listEmp)
    {
        LocalDate date = LocalDate.now();
        for(int i=0;i<listEmp.size();i++)
        {
            System.out.println(listEmp.get(i).getName());
            listEmp.get(i).setOutput(sc.nextDouble());
            listEmp.get(i).setDate(date+"");
        }   
        return listEmp;
    }


}
