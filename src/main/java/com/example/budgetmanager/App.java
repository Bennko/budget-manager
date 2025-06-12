package com.example.budgetmanager;
import java.util.Scanner;

import com.example.budgetmanager.Expenses.ExpensesController;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        ExpensesController expensesController = new ExpensesController();
        System.out.println( "Welcome to the Budget Manager!");
        while(true){
            System.out.println("Menu: 1: Add new expense 2: View all expenses 3: View expenses associated with a specific tag 4: Exit");
            int menuInput = scanner.nextInt();
            switch(menuInput){
                case 1:
                    expensesController.addExpenses(scanner);
                    break;
                case 2:
                    expensesController.printAllExpenses();
                    break;
                case 3:
                    expensesController.printExpensesByTag(scanner);
                    break;
                case 4:
                    break;
            }
            if(menuInput == 4){
                break;
            }
        }
        scanner.close();
    }
}