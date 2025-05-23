package com.example.budgetmanager;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Welcome to the Budget Manager!");
        int a = 1;
        while(1 == a){
            System.out.print("How much did you spend: ");
            double amount = scanner.nextDouble();
            System.out.print("Why: ");
            String description = scanner.nextLine();
            try(Connection conn = DriverManager.getConnection("jdbc:sqlite:budget.db")){
                String insertSQL = "INSERT INTO expenses (amount, description) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertSQL);
                pstmt.setDouble(1, amount);
                pstmt.setString(2, description);
                pstmt.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}