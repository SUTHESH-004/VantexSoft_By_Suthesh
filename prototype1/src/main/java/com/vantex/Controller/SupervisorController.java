package com.vantex.Controller;
import com.vantex.view.*;
import com.vantex.DAO.Attendance_DAO;
import com.vantex.DAO.Employee_DAO;
import java.util.*;
import com.vantex.Model.*;
public class SupervisorController {
    public static void start(EmployeeInfo ei) {
        SupervisorConsoleUI scui = new SupervisorConsoleUI();
        Choice c = scui.displayMenu();
        switch(c.getChoice())
        {
            case 1 -> {
                   Choice h = scui.displayAttendanceMenu();
                   switch(h.getChoice())
                   {
                    case 1->{
                        ArrayList<EmployeeInfo>ert = Employee_DAO.getEmployee();
                        Attendance_DAO.markAttendance()
                    }
                   }
            }
        }

    }
}
