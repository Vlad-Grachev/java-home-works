package com.netcracker.crud.status;

public class Status {
    private String status = "default status";

    public Status(){}

    public Status(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
