package com.vantex.view;

import java.util.*;

public class Scan {
    static Scanner sc = new Scanner(System.in);
    public static Scanner getScanner() {
        return sc;
    }
    public static void closeScanner() {
        if (sc != null) {
            sc.close();
        }
    }
}
