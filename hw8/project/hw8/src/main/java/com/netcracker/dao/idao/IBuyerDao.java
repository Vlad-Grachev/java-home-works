package com.netcracker.dao.idao;

import java.util.List;

import com.netcracker.model.Buyer;

public interface IBuyerDao {
    void saveBuyer(Buyer buyer);
    List<Buyer> findAllBuyers();
    Buyer findBuyerById(int id);
    Buyer updateBuyerById(int id, String surname, String district, Integer discount);
    long getRowsNumber();
    List<Buyer> getInhabitedDistricts();// task 2.a)
    List<Buyer> getBuyersFromDistrict(String district); // task 3.a)
}
