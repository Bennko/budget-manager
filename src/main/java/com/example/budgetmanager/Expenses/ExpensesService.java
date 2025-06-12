package com.example.budgetmanager.Expenses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ExpensesService {
    private static final ExpensesRepository expensesRepository = new ExpensesRepository();

    public void addExpenses(double amount, String description, String tag, String date){
        ExpenseTag parsedTag = ExpenseTag.valueOf(tag);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = sdf.parse(date);
            ExpensesModel newExpense = new ExpensesModel(amount, description, parsedTag , parsedDate);
            expensesRepository.addExpenses(newExpense);
        }catch(ParseException e){
            System.out.println("Invalid Date format. Please enter yyyy-MM-dd.");
        }
    }

    public ArrayList<ExpensesModel> getAllExpenses(){
        return expensesRepository.getAllExpenses();
    }

    public ArrayList<ExpensesModel> getExpensesByTag(ExpenseTag tag){
        return expensesRepository.getExpensesByTag(tag);
    }
}
