package com.ncu.ExpenseManager;

import java.util.Date;
import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public Expense createExpense() {
        Expense expense = new Expense();

        System.out.print("Enter expense ID: ");
        expense.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter expense name: ");
        expense.setName(scanner.nextLine());

        System.out.print("Enter expense cost: ");
        expense.setCost(Double.parseDouble(scanner.nextLine()));

        System.out.print("Enter color: ");
        expense.setColor(scanner.nextLine());

        System.out.print("Enter URL: ");
        expense.setUrl(scanner.nextLine());
        
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
		Date date = new Date(dateString);
        expense.setDate(date);

        return expense;
    }

	public String nextLine() {
		// TODO Auto-generated method stub
		return null;
	}

}

