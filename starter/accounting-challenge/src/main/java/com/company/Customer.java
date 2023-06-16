package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    /* class structure is not allowed
    Customer(){}
    Customer(int id, String name, AccountRecord newCharge){
        this.id = id;
        this.name = name;
        this.charges.add(newCharge);

    public void addCharge(AccountRecord charge){
        this.charges.add(charge);
    }
    }*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int balance = 0;

        for(AccountRecord charge : this.charges){
            balance += charge.getCharge();
        }

        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        String out = String.valueOf(this.id) + ' ' + this.name + ' ' + String.valueOf(getBalance());
        return out;
    }
}
