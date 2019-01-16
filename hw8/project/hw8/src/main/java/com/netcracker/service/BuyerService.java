package com.netcracker.service;

import com.netcracker.config.SpringCofig;
import com.netcracker.dao.idao.IBuyerDao;
import com.netcracker.model.Buyer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class BuyerService {
    private static AbstractApplicationContext context =
            new AnnotationConfigApplicationContext(SpringCofig.class);
    private static IBuyerDao service = (IBuyerDao) context.getBean("buyerDao");

    public static Buyer saveBuyer(Buyer buyer){
        service.saveBuyer(buyer);
        return buyer;
    }

    public static void findAllBuyers(){
        TablePrinter.print(service.findAllBuyers());
    }

    public static Buyer findBuyerById(int id){
        return service.findBuyerById(id);
    }

    public static Buyer updateBuyerById(int id, String surname, String district, Integer discount){
        return service.updateBuyerById(id, surname, district, discount);
    }

    public static long getRowsNumber(){
        return service.getRowsNumber();
    }

    public static void getInhabitedDistricts(){
        TablePrinter.print(service.getInhabitedDistricts());
    }

    public static void getBuyersFromDistrict(String district) {
        TablePrinter.print(service.getBuyersFromDistrict(district));
    }
}
