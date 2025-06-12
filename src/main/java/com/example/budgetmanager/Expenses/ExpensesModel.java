package com.example.budgetmanager.Expenses;
import java.util.Date;

public class ExpensesModel {
    private double amount;
    private String description;
    private ExpenseTag expenseTag;
    private Date date;

    public ExpensesModel(double amount, String description, ExpenseTag expenseTag, Date date){
        this.amount = amount;
        this.description = description;
        this.expenseTag = expenseTag;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public ExpenseTag getExpenseTag() {
        return expenseTag;
    }

    public Date getDate() {
        return date;
    }
}
