package com.netcracker.crud.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    private int id;
    private String secondName;
    private String district;
    private int discount;

    public Buyer(){}

    public Buyer(int id, String secondName, String district, int discount) {
        this.id = id;
        this.secondName = secondName;
        this.district = district;
        this.discount = discount;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getDistrict() {
        return district;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", secondName='" + secondName + '\'' +
                ", district='" + district + '\'' +
                ", discount=" + discount +
                '}';
    }
}
