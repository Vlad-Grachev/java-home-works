package com.netcracker.dao.idao;

import com.netcracker.model.Purchase;

import java.util.List;
import java.sql.Date;

public interface IPurchaseDao {
    void savePurchase(Purchase purchase);
    List<Purchase> findAllPurchases();
    Purchase findPurchaseById(int id);
    Purchase updatePurchaseById(int id, Date date,
        int shopId, int buyerId, int bookId, int qty, double sum);
    long getRowsNumber();
    List<Purchase> getPurchaseMonths(); // task 2.c)
    List<Purchase> getSurnameAndShopNameFromPurchases(); // task 4.a)
    List<Purchase> getDateSurnameDiscountTitleFromPurchases(); // task 4.b)
    List<Purchase> getPurchasesWithSumNotLessThan(double bound); // task 5.a)
    List<Purchase> getPurchasesInNativeDistrictSinceMarch(); // task 5.b)

}
