package com.vantex.view;

import java.util.ArrayList;

import com.vantex.Modal.Choice;
import com.vantex.Modal.EmployeeInfo;

public class SupervisorConsoleUI extends ConsoleUI {
    public Choice displayMenu() {
        Choice c = new Choice();
        System.out.println("Welcome! Press the numbers to indicate what you want to do:");
        System.out.println("1. Enter Attendance");
        System.out.println("2 . Enter Output Of the day");
        System.out.println("3 . Get Output and the attendance");
        System.out.println("4 . get attendance only");
        System.out.println("5 . getOutput Only");
        c.setChoice(Scan.sc.nextInt());
        return c;
    }

    public void displayAttendanceAndData(ArrayList<EmployeeInfo> ert) {
        for (int i = 0; i < ert.size(); i++) {
            System.out.println(ert.get(i).getName());
            System.out.println(ert.get(i).getStatus());
            System.out.println(ert.get(i).getOutput());
            System.out.println();
        }
    }

    public void displayAttendace(ArrayList<EmployeeInfo> ert) {
        for (int i = 0; i < ert.size(); i++) {
            System.out.println(ert.get(i).getName());

            System.out.println(ert.get(i).getStatus());
            System.out.println();
        }
    }

    public void displayOutput(ArrayList<EmployeeInfo> ert) {
        for (int i = 0; i < ert.size(); i++) {
            System.out.println(ert.get(i).getName());

            System.out.println(ert.get(i).getOutput());
            System.out.println();
        }
    }

}
