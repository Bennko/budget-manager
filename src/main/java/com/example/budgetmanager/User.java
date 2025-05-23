package com.example.budgetmanager;

public class User {
    private String userName;
    private int userId;
    private double budget;
    
    public String getUserName(){
        return userName;
    }

    public void setUserName(String name){
        this.userName = name;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int id){
        this.userId = id;
    }

    public double getBudget(){
        return budget;
    }

    public void setBudget(double amount){
        this.budget = amount;
    }
}
