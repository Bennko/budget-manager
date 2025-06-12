package com.example.budgetmanager.Expenses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.example.budgetmanager.db.DatabaseHelper;

public class ExpensesRepository {
    public boolean addExpenses(ExpensesModel newExpense){
        try(Connection connection = DatabaseHelper.getConnection()){
            String sqlInput = "INSERT INTO expenses (amount, description, tag, date) VALUES (?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sqlInput);
            pstm.setDouble(1, newExpense.getAmount());
            pstm.setString(2, newExpense.getDescription());
            pstm.setString(3, newExpense.getExpenseTag().name());
            pstm.setDate(4, new java.sql.Date(newExpense.getDate().getTime()));

            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ExpensesModel> getAllExpenses(){
        try(Connection connection = DatabaseHelper.getConnection()){
            String sqlInput = "SELECT * FROM expenses";
            PreparedStatement pstmt = connection.prepareStatement(sqlInput);
            ResultSet rs = pstmt.executeQuery();
            return resultSetToExpensesModel(rs);
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ExpensesModel> getExpensesByTag(ExpenseTag tag){
        try(Connection connection = DatabaseHelper.getConnection()){
            String sqlInput = "SELECT * FROM expenses WHERE tag = ?";
            PreparedStatement pstmt = connection.prepareStatement(sqlInput);
            pstmt.setString(1, tag.name());
            ResultSet rs = pstmt.executeQuery();
            return resultSetToExpensesModel(rs);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<ExpensesModel> resultSetToExpensesModel(ResultSet rs){
        try{
            ArrayList<ExpensesModel> allExpenses= new ArrayList<ExpensesModel>();
            ExpenseTag parsedTag = null;
            Date parsedDate = null;
            while(rs.next()){
                if(rs.getString("tag") != null){
                    parsedTag = ExpenseTag.valueOf(rs.getString("tag"));
                }
                if(rs.getDate("date") != null){
                    parsedDate = new java.util.Date(rs.getDate("date").getTime());
                }
                allExpenses.add(new ExpensesModel(rs.getDouble("amount"), rs.getString("description"), parsedTag, parsedDate));
            }
            return allExpenses;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
