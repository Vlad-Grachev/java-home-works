package com.netcracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private int id;
    @Column
    private String title;
    @Column
    private double price;
    @Column
    private String storage;
    @Column
    private int qty;

    public Book(){}

    public Book(int id, String title, double price, String storage, int qty) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.storage = storage;
        this.qty = qty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getStorage() {
        return storage;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", storage='" + storage + '\'' +
                ", qty=" + qty +
                '}';
    }
}
