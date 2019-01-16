package com.netcracker.dao.idao;

import com.netcracker.model.Bookshop;

import java.util.List;

public interface IBookshopDao {
    void saveBookshop(Bookshop bookshop);
    List<Bookshop> findAllBookshops();
    Bookshop findBookshopById(int id);
    Bookshop updateBookshopById(int id, String name, String district, Integer comission);
    long getRowsNumber();
    List<Bookshop> getBookshopsFromSpecificDistricts(String... distritcs); // task 3.b)
    List<Bookshop> getBookshopsWithRestrictsOnDistrictAndBuyerDiscount(
            String exceptDisctrict, int lowDiscountBound, int upDiscountBound);
}
