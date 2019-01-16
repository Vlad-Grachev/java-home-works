package com.netcracker.service;

import com.netcracker.config.SpringCofig;
import com.netcracker.dao.idao.IBookDao;
import com.netcracker.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class BookService {
    private static AbstractApplicationContext context =
            new AnnotationConfigApplicationContext(SpringCofig.class);
    private static IBookDao service = (IBookDao) context.getBean("bookDao");

    public static Book saveBook(Book book){
        service.saveBook(book);
        return book;
    }

    public static void findAllBooks(){
        TablePrinter.print(service.findAllBooks());
    }

    public static Book findBookById(int id){
        return service.findBookById(id);
    }

    public static Book updateBookById(int id, String title, Integer price, String storage, Integer qty){
        return service.updateBookById(id, title, price, storage, qty);
    }

    public static long getRowsNumber(){
        return (service.getRowsNumber());
    }

    public static void getBooksWithUniqueTitleAndPrice(){ // task 2.a)
        TablePrinter.print(service.getBooksWithUniqueTitleAndPrice());
    }

    public static void getBooksWithSpecificTitleOrPrice(String title, double price){ // task 3.c)
        TablePrinter.print(service.getBooksWithSpecificTitleOrPrice(title, price));
    }

    public static void getBooksSoldInTheirStorage(){
        TablePrinter.print(service.getBooksSoldInTheirStorage());
    }
}
