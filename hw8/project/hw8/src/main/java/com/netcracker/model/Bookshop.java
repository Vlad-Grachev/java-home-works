package com.netcracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookshops")
public class Bookshop {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String district;
    @Column
    private int commission;

    public Bookshop(){}

    public Bookshop(int id, String name, String district, int commission) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.commission = commission;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getCommission() {
        return commission;
    }

    @Override
    public String toString() {
        return "Bookshop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", commission=" + commission +
                '}';
    }
}
