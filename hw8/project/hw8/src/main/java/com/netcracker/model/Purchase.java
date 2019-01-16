package com.netcracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    private int id;
    @Column
    private Date date;
    @Column(name = "shop_id")
    private int shopId;
    @Column(name = "buyer_id")
    private int buyerId;
    @Column(name = "book_id")
    private int bookId;
    @Column
    private int qty;
    @Column
    private double sum;

    public Purchase(){}

    public Purchase(int id, Date date, int shopId, int buyerId, int bookId, int qty, double sum) {
        this.id = id;
        this.date = date;
        this.shopId = shopId;
        this.buyerId = buyerId;
        this.bookId = bookId;
        this.qty = qty;
        this.sum = sum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getShopId() {
        return shopId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getQty() {
        return qty;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", shopId=" + shopId +
                ", buyerId=" + buyerId +
                ", bookId=" + bookId +
                ", qty=" + qty +
                ", sum=" + sum +
                '}';
    }
}