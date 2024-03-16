package com.vantex.view;

import com.vantex.Modal.Choice;

public class EmployeeConsoleUI extends ConsoleUI{
    public Choice displayMenu()
    {
        Choice c = new Choice();
        System.out.println("Enter your choice");
        System.out.println("1. view your attendance");
        System.out.println("2. See your performance");
        System.out.println("3. view your data on the company");
        System.out.println("4. Request Permission");
        c.setChoice(Scan.sc.nextInt());
        return c;
    }
}
