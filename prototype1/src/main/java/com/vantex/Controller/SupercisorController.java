package com.vantex.Controller;
import com.vantex.view.*;
import com.vantex.Model.*;
public class SupercisorController {
    public static void start() {
        SupervisorConsoleUI scui = new SupervisorConsoleUI();
        Choice c = scui.displayMenu();
        switch(c.getChoice())
        {
            case 1 -> System.out.println("Enter Attendance");
            case 2 -> System.out.println("Enter Output for Today");
            case 3 ->   
        }

    }
}
