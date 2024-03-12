package com.vantex.view;

// import java.util.ArrayList;

import com.vantex.Model.*;

public class SupervisorConsoleUI extends ConsoleUI{
    public Choice displayMenu() {
        Choice c = new Choice();
        System.out.println("Welcome! Press the numbers to indicate what you want to do:");
        System.out.println("1. Enter Attendance");
        System.out.println("2. Output Entry");
        System.out.println("3. View Reports");
        System.out.println("4. Send Todays report");
        System.out.println("5. Exit");
        c.setChoice(Scan.sc.nextInt());
        return c;
    }
}
