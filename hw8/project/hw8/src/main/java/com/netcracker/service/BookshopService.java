package com.netcracker.service;

import com.netcracker.config.SpringCofig;
import com.netcracker.dao.idao.IBookshopDao;
import com.netcracker.model.Bookshop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class BookshopService {
    private static AbstractApplicationContext context =
            new AnnotationConfigApplicationContext(SpringCofig.class);
    private static IBookshopDao service = (IBookshopDao) context.getBean("bookshopDao");

    public static Bookshop saveBookshop(Bookshop bookshop){
        service.saveBookshop(bookshop);
        return bookshop;
    }

    public static void findAllBookshops(){
        TablePrinter.print(service.findAllBookshops());
    }

    public static Bookshop findBookshopById(int id){
        return service.findBookshopById(id);
    }

    public static Bookshop updateBookshopById(int id, String name, String district, Integer comission){
        return service.updateBookshopById(id, name, district, comission);
    }

    public static long getRowsNumber(){
        return service.getRowsNumber();
    }

    public static void getBookshopsFromSpecificDistricts(String... distritcs){
        TablePrinter.print(service.getBookshopsFromSpecificDistricts(distritcs));
    }

    public static void getBookshopsWithRestrictsOnDistrictAndBuyerDiscount(
            String exceptDisctrict, int lowDiscountBound, int upDiscountBound){
        TablePrinter.print(service
                .getBookshopsWithRestrictsOnDistrictAndBuyerDiscount(
                exceptDisctrict, lowDiscountBound, upDiscountBound));
    }
}
