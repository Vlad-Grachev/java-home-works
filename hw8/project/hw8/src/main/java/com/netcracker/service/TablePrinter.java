package com.netcracker.service;

import java.util.List;

public class TablePrinter {
    public static void print(List table){
        System.out.println();
        for (Object o: table){
            System.out.println(o.toString());
        }
    }
}
