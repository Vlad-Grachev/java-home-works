package com.netcracker.dao.idao;

import com.netcracker.model.Book;

import java.util.List;

public interface IBookDao {
    void saveBook(Book book);
    List<Book> findAllBooks();
    Book findBookById(int id);
    Book updateBookById(int id, String title, Integer price, String storage, Integer qty);
    long getRowsNumber();
    List<Book> getBooksWithUniqueTitleAndPrice(); // task 2.a)
    List<Book> getBooksWithSpecificTitleOrPrice(String title, double price); // task 3.c)
    List<Book> getBooksSoldInTheirStorage(); // task 5.d)
}
