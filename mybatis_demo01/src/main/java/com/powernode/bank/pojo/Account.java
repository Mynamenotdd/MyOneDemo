package com.powernode.bank.pojo;

public class Account {
    private  int id ;
    private  String actno;
    private  double balance;

    public Account() {
    }

    public Account(int id, String actno, double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
