package com.vantex.Model;

import java.sql.Date;

public class AttendanceInfo {
    String Emp_Name;
    String status;
    Date Today_date;
    public void setEmp_Name(String emp_Name) {
        Emp_Name = emp_Name;
    }
    public void setStatus(String status) {
        if (status.equalsIgnoreCase("p") || status.equalsIgnoreCase("present"))
            this.status = "Present";
        else if (status.equalsIgnoreCase("a") || status.equalsIgnoreCase("absent"))
            this.status = "Absent";
    }

    public void setToday_date(Date today_date) {
        Today_date = today_date;
    }

}
