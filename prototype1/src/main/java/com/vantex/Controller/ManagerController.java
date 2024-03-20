package com.vantex.Controller;

import com.vantex.view.ManagerConsoleUI;
import com.vantex.DAO.Attendance_DAO;
import com.vantex.DAO.Daily_Output_DAO;
import com.vantex.DAO.Employee_DAO;
import com.vantex.Modal.Choice;
import com.vantex.Modal.EmployeeInfo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class ManagerController {
    public static void start(EmployeeInfo ei) throws ClassNotFoundException, SQLException {
        ManagerConsoleUI scui = new ManagerConsoleUI();
        Choice c = scui.displayMenu();
        switch (c.getChoice()) {
            // Enter your attendance
            case 1 -> {
                ArrayList<EmployeeInfo> ert = Employee_DAO.getEmployeeByTeamId(ei);
                ArrayList<EmployeeInfo> ert2 = scui.putAttendance(ert); // get attendance from user
                Attendance_DAO.markAttendance(ert2, ei); // marking attendance in db
                ContinueOrExit(ei, scui.continueOrNot());
            }
            // Enter your Output Entry
            case 2 -> {
                ArrayList<EmployeeInfo> ert = Employee_DAO.getEmployeeByTeamId(ei);
                ArrayList<EmployeeInfo> ert2 = scui.putOutput(ert);
                Daily_Output_DAO.markOutput(ert2, ei);
                ContinueOrExit(ei, scui.continueOrNot());
            }
            // view report both employee attendance and output per day
            case 3 -> {
                LocalDate n = LocalDate.now();
                // EmployeeInfo e =new EmployeeInfo();
                ArrayList<EmployeeInfo> ert = Attendance_DAO.getAttendanceAndOutput(n + "", ei);
                scui.displayAttendanceAndData(ert);
                ContinueOrExit(ei, scui.continueOrNot());

            }
            // view attendance only
            case 4 -> {
                LocalDate n = LocalDate.now();
                ArrayList<EmployeeInfo> ert = Attendance_DAO.getAttendance(n + "", ei);
                scui.displayAttendace(ert);
                ContinueOrExit(ei, scui.continueOrNot());
            }
            // view attendance only
            case 5 -> {
                LocalDate n = LocalDate.now();
                ArrayList<EmployeeInfo> ert = Attendance_DAO.getOutput(n + "", ei);
                scui.displayOutput(ert);
                ContinueOrExit(ei, scui.continueOrNot());
            }
            case 6 -> {
                EmployeeInfo employeeToAdd = scui.getEmployeeDetailstoAdd();
                Employee_DAO.addEmployee(employeeToAdd);
                ContinueOrExit(ei, scui.continueOrNot());
            }
            case 7 -> {
                EmployeeInfo employeeToRemove = scui.getEmployeeDetailstoRemove();
                Employee_DAO.removeEmployee(employeeToRemove);
                ContinueOrExit(ei, scui.continueOrNot());
            }
            case 8 -> {
                ArrayList<EmployeeInfo> empdetailtoshow = Employee_DAO.getAllEmployeeDetails();
                ManagerConsoleUI.showEmpdetails(empdetailtoshow);

                ContinueOrExit(ei, scui.continueOrNot());

            }

        }
    }

    public static void ContinueOrExit(EmployeeInfo a, boolean b) throws ClassNotFoundException, SQLException {
        if (b) {
            start(a);
            System.exit(0);
        } else {
            System.exit(0);
        }
    }
}
