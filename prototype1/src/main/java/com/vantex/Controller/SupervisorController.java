package com.vantex.Controller;

import com.vantex.view.*;
import com.vantex.DAO.Attendance_DAO;
import com.vantex.DAO.Daily_Output_DAO;
import com.vantex.DAO.Employee_DAO;
import java.time.*;
import java.sql.SQLException;
import java.util.*;
import com.vantex.Modal.*;
public class SupervisorController {
    public static void start(EmployeeInfo ei) throws ClassNotFoundException, SQLException {
        SupervisorConsoleUI scui = new SupervisorConsoleUI();
        Choice c = scui.displayMenu();
        switch (c.getChoice()) {
            // Enter your attendance
            case 1 -> {
                ArrayList<EmployeeInfo> ert = Employee_DAO.getEmployeeByTeamId(ei);
                ArrayList<EmployeeInfo> ert2 = scui.putAttendance(ert);
                Attendance_DAO.markAttendance(ert2, ei);
            }

            // Enter your Output Entry
            case 2 -> {
                ArrayList<EmployeeInfo> ert = Employee_DAO.getEmployeeByTeamId(ei);
                ArrayList<EmployeeInfo> ert2 = scui.putOutput(ert);
                Daily_Output_DAO.markOutput(ert2, ei);

            }
            // view report both employee attendance and output per day
            case 3-> {
                LocalDate n = LocalDate.now();
                ArrayList<EmployeeInfo> ert = Attendance_DAO.getAttendanceAndOutput(n+" ");


            }

        }
    }
}4
