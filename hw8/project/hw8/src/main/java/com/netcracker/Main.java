package com.netcracker;

import com.netcracker.service.BookService;
import com.netcracker.service.BookshopService;
import com.netcracker.service.BuyerService;
import com.netcracker.service.PurchaseService;

public class Main {
    public static void task1(){
        System.out.println("Initial data: ");

        BookService.findAllBooks();
        System.out.println("Total rows: " + BookService.getRowsNumber());

        BuyerService.findAllBuyers();
        System.out.println("Total rows: " + BuyerService.getRowsNumber());

        BookshopService.findAllBookshops();
        System.out.println("Total rows: " + BookshopService.getRowsNumber());

        PurchaseService.findAllPurchases();
        System.out.println("Total rows: " + PurchaseService.getRowsNumber());
    }
    public static void task2(){
        // task 2.a
        BookService.getBooksWithUniqueTitleAndPrice();
        System.out.println("That was ---------> task 2.a");
        // task 2.b
        BuyerService.getInhabitedDistricts();
        System.out.println("That was ---------> task 2.b");
        // task 2.c
        PurchaseService.getPurchaseMonths();
        System.out.println("That was ---------> task 2.c");
    }

    public static void task3(){
        // task 3.a)
        BuyerService.getBuyersFromDistrict("Leninsky");
        System.out.println("That was ---------> task 3.a");
        // task 3.b)
        BookshopService.getBookshopsFromSpecificDistricts("Sormovsky", "Sovetsky");
        System.out.println("That was ---------> task 3.b");
        // task 3.c)
        BookService.getBooksWithSpecificTitleOrPrice("Windows", 1400);
        System.out.println("That was ---------> task 3.c");
    }

    public static void task4(){
        // "task 4.a)
        PurchaseService.getSurnameAndShopNameFromPurchases();
        System.out.println("That was ---------> task 4.a");
        // task 4.b)
        PurchaseService.getDateSurnameDiscountTitleFromPurchases();
        System.out.println("That was ---------> task 4.b");
    }

    public static void task5(){
        // task 5.a)
        PurchaseService.getPurchasesWithSumNotLessThan(12000);
        System.out.println("That was ---------> task 5.a");
        // task 5.b)
        PurchaseService.getPurchasesInNativeDistrictSinceMarch();
        System.out.println("That was ---------> task 5.b");
        // task 5.c)
        BookshopService.getBookshopsWithRestrictsOnDistrictAndBuyerDiscount("Leninsky", 10, 55);
        System.out.println("That was ---------> task 5.c");
        // task 5.d)
        BookService.getBooksSoldInTheirStorage();
        System.out.println("That was ---------> task 5.d");
    }

    public static void doAllTasks(){
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void main(String[] args) {
        doAllTasks();
    }
}
