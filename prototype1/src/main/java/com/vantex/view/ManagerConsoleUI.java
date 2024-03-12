package com.vantex.view;

import java.util.Scanner;
import com.vantex.Model.*;
public class ManagerConsoleUI extends ConsoleUI{
    public Choice displayMenu() {
        Scanner sc = Scan.sc;
        Choice c = new Choice();
        System.out.println("Welcome! Press the numbers to indicate what you want to do:");
        System.out.println("1. Enter Attendance");
        System.out.println("2. View Reports");
        System.out.println("3. Output Entry");
        System.out.println("4. Send Todays report");
        System.out.println("5. Edit Employee details");
        System.out.println("6. Exit");
        c.setChoice(sc.nextInt());
        return c;
    }
    
}
