package com.vantex.Model;

public class EmployeeInfo {
    String name;
    String role;
    String status;
    int emp_id;
    String team_name;
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
