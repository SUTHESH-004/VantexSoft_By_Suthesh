package com.vantex;
import java.sql.SQLException;

import com.vantex.Controller.App;
import com.vantex.view.ConsoleUI;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConsoleUI.welcomeDisplay();
        App.start();
    }
}