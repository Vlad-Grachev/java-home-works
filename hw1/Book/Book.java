package hw1.book;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        String sBook = "Book[name=" + name + ",authors={";
        for (int i = 0; i < authors.length; i++){
            sBook += authors[i].toString();
            if(i != authors.length - 1)
                sBook += ",";
        }
        sBook = sBook + "},price=" + ",qty=" + qty + "]";
        return sBook;
    }

    public String getAuthorsNames(){
        String sAuthors = "";
        for (int i = 0; i < authors.length; i++){
            sAuthors += authors[i].getName();
            if(i != authors.length - 1)
                sAuthors += ",";
        }
        return sAuthors;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if( obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return name.equals(book.name) && Arrays.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        for(Author a: authors)
            result = 31 * result + a.hashCode();
        return result;
    }
}