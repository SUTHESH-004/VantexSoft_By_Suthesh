package com.vantex.view;

import java.util.ArrayList;

import com.vantex.Modal.Choice;
import com.vantex.Modal.EmployeeInfo;

public class ManagerConsoleUI extends SupervisorConsoleUI {
    public Choice displayMenu() {
        Choice c = new Choice();
        System.out.println("Welcome! Press the numbers to indicate what you want to do:");
        System.out.println("1. Enter Attendance");
        System.out.println("2 . Enter Output Of the day");
        System.out.println("3 . Get Output and the attendance");
        System.out.println("4 . get attendance only");
        System.out.println("5 . getOutput Only");
        System.out.println("6 . add employee");
        System.out.println("7 . delete Employee");
        System.out.println("8 . get the all the employee details");
        c.setChoice(Scan.sc.nextInt());
        return c;
    }

    public EmployeeInfo getEmployeeDetailstoAdd() {
        EmployeeInfo eitoAdd = new EmployeeInfo();
        System.out.println("Enter the details for the employee to add");
        System.out.println("Enter the employee Name");
        eitoAdd.setName(Scan.sc.next());
        System.out.println("Enter the employee email ");
        eitoAdd.setEmail(Scan.sc.next());
        System.out.println("Enter the employee password");
        eitoAdd.setPassword(Scan.sc.next());
        System.out.println("Enter the employee Date");
        eitoAdd.setDate(Scan.sc.next());
        // System.out.println("Enter the employee team_id");
        // eitoAdd.setTeamId();
        System.out.println("Enter the employee role");
        eitoAdd.setRole(Scan.sc.next());
        return eitoAdd;

    }

    public EmployeeInfo getEmployeeDetailstoRemove() {
        System.out.println("Enter the email of the employee to remove");
        EmployeeInfo ei = new EmployeeInfo();
        ei.setEmail(Scan.sc.next());
        return ei;
    }

    public static void showEmpdetails(ArrayList<EmployeeInfo> list) {
        System.out.println("╔════════════╦═════════════════╦═══════════════════╦═════════════╦══════════════════╗");
        System.out.printf("%║-15s║%-15s║%-15s║%-15s\n", "Name", "email", "DateOfBirth", "Roles║");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("║%-15s║%-15s║%-15s║%-15s║\n",

                    list.get(i).getName(),
                    list.get(i).getEmail(),
                    list.get(i).getDateOfbirth(),
                    list.get(i).getRole());
            System.out.println("╚═══════════════╬══════════════════════╬══════════════════╬═══════════════════╝");
        }

    }
}
