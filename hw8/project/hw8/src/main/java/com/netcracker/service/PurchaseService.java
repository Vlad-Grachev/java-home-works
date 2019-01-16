package com.netcracker.service;

import com.netcracker.config.SpringCofig;
import com.netcracker.dao.idao.IPurchaseDao;
import com.netcracker.model.Purchase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.sql.Date;

public class PurchaseService {
    private static AbstractApplicationContext context =
            new AnnotationConfigApplicationContext(SpringCofig.class);
    private static IPurchaseDao service = (IPurchaseDao) context.getBean("purchaseDao");

    public static Purchase savePurchase(Purchase purchase){
        service.savePurchase(purchase);
        return purchase;
    }

    public static void findAllPurchases(){
        TablePrinter.print(service.findAllPurchases());
    }

    public static Purchase findPurchaseById(int id){
        return service.findPurchaseById(id);
    }

    public static Purchase updatePurchaseById(int id, Date date,
            int shopId, int buyerId, int bookId, int qty, double sum){
        return service.updatePurchaseById(id, date, shopId, buyerId, bookId, qty, sum);
    }

    public static long getRowsNumber(){
        return service.getRowsNumber();
    }

    public static void getPurchaseMonths(){
        TablePrinter.print(service.getPurchaseMonths());
    }

    public static void getSurnameAndShopNameFromPurchases(){
        TablePrinter.print(service.getSurnameAndShopNameFromPurchases());
    }

    public static void getDateSurnameDiscountTitleFromPurchases(){
        TablePrinter.print(service.getDateSurnameDiscountTitleFromPurchases());
    }

    public static void getPurchasesWithSumNotLessThan(double bound){
        TablePrinter.print(service.getPurchasesWithSumNotLessThan(bound));
    }

    public static void getPurchasesInNativeDistrictSinceMarch(){
        TablePrinter.print(service.getPurchasesInNativeDistrictSinceMarch());
    }
}
