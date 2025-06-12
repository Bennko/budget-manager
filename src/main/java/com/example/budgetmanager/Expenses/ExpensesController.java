package com.example.budgetmanager.Expenses;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpensesController {
    private static final SimpleDateFormat sdf = new SimpleDateFormat();
    private static final ExpensesService service = new ExpensesService();

    public void addExpenses(Scanner scanner){
        System.out.println("Adding a new Expense.");
        System.out.print("How much did you spend: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("On what did you spend it: ");
        String description = scanner.nextLine();
        System.out.print("What category is it (UTILITIES, ENTERTAINMENT, CHARITY, BUSINESS, FOOD): ");
        String tag = scanner.nextLine();
        System.out.print("What date was it (yyyy-MM-dd): ");
        String date = scanner.nextLine().trim();

        new ExpensesService().addExpenses(amount, description, tag, date);
    }

    public void printAllExpenses(){
        ArrayList<ExpensesModel> allExpenses = service.getAllExpenses();
        printExpenses(allExpenses);
    }

    public void printExpensesByTag(Scanner scanner){
        System.out.print("Enter the tag that you want to search up (UTILITIES, ENTERTAINMENT, CHARITY, BUSINESS, FOOD): ");
        scanner.nextLine();
        String inputTag = scanner.nextLine();
        System.out.println(inputTag);
        ExpenseTag parsedTag = ExpenseTag.valueOf(inputTag);
        ArrayList<ExpensesModel> expensesWithTag = service.getExpensesByTag(parsedTag);
        printExpenses(expensesWithTag);
    }

    private void printExpenses(ArrayList<ExpensesModel> expenses){
        System.out.printf("%-10s %-20s %-15s %-12s%n", "Amount", "Description", "Tag", "Date");
        System.out.println("---------------------------------------------------------------------");
        for(ExpensesModel e : expenses){
            String dateStr = (e.getDate() != null) ? sdf.format(e.getDate()) : "N/A";
            System.out.printf(
                "%-10.2f %-20s %-15s %-12s%n",
                e.getAmount(),
                e.getDescription(),
                e.getExpenseTag(),
                dateStr
            );
        }
    }
}