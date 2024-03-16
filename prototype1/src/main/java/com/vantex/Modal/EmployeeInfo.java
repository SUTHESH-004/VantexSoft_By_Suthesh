package com.vantex.Modal;

public class EmployeeInfo {
    String name;
    String role;
    String status;
    int emp_id;
    String team_name;
    int team_id;
    String date;
    double Output ;
    public void setOutput(double output) {
        Output = output;
    }
    public double getOutput() {
        return Output;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setStatus(String status) {
        if(status.equalsIgnoreCase("P")||status.equalsIgnoreCase("present"))
        this.status = "Present";
        else
        this.status = "Absent";
    }
    public String getStatus() {
        return status;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
