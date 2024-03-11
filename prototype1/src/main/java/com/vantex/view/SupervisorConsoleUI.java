package com.vantex.view;
import com.vantex.Model.*;
public class SupervisorConsoleUI {
        public Choice displayMenu() {
            Choice c = new Choice();
            System.out.println("Welcome! Press the numbers to indicate what you want to do:");
            System.out.println("1. Enter Attendance");
            System.out.println("2. View Reports");
            System.out.println("3. Output Entry");
            System.out.println("4.Send Todays report");
            System.out.println("5. Exit");
            c.setChoice(Scan.sc.nextInt());
            return c;
        }
        public Choice displayAttendanceMenu()
        {
            System.out.println("Enter you choice");
            System.out.println("1. view Todays Attendance");
            System.out.println("2. view Todays Report");
            System.out.println("3. view particular date Attendance");
            System.out.println("4. view particular date Report");
            System.our.println("5. view both Attendance")
        }

}
