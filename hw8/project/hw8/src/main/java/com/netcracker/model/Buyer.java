package com.netcracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    private int id;
    @Column
    private String surname;
    @Column
    private String district;
    @Column
    private int discount;

    public Buyer(){}

    public Buyer(int id, String surname, String district, int discount) {
        this.id = id;
        this.surname = surname;
        this.district = district;
        this.discount = discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getSurname() {
        return surname;
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
                ", surname='" + surname + '\'' +
                ", district='" + district + '\'' +
                ", discount=" + discount +
                '}';
    }
}
