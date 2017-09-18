package com.restaurant;

public class Table {

    private int id;
    private int seats;
    private boolean custSeatedFlag;

    public Table(int id, int seats) {
        this.id = id;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isCustSeatedFlag() {
        return custSeatedFlag;
    }

    public void setCustSeatedFlag(boolean custSeatedFlag) {
        this.custSeatedFlag = custSeatedFlag;
    }
}
