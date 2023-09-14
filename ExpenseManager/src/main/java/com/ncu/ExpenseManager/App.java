package com.ncu.ExpenseManager;

import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class App {
	public static void main(String[] args) {
		
		 

	    Configuration con = new Configuration().configure().addAnnotatedClass(Expense.class);
	    Scanner sc = new Scanner(System.in);

	    SessionFactory sf = con.buildSessionFactory();

	    Session session = sf.openSession();

	    CreateOperation createOperation = new CreateOperation();
	    ReadOperation readOperation = new ReadOperation();
	    UpdateOperation updateOperation = new UpdateOperation();
	    DeleteOperation deleteExpenseById = new DeleteOperation();
	    UserInput userInput = new UserInput();

	    boolean exit = false;
	    
	    System.out.println("***************************************");
        System.out.println("*        Expense Manager App          *");
        System.out.println("***************************************");

	    while (!exit) {
	        System.out.println("Choose an operation:");
	        System.out.println("1. Insert Expense");
	        System.out.println("2. View All Expenses");
	        System.out.println("3. Update Expense");
	        System.out.println("4. Delete Expense by ID");
	        System.out.println("5. Search Expense by ID");
	        System.out.println("6. Exit");

	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1:
	                Expense newExpense = userInput.createExpense();
	                createOperation.insertExpense(newExpense, session);
	                System.out.println("Expense inserted successfully.");
	                break;

	            case 2:
	                List<Expense> expenses = readOperation.getAllExpenses(session);
	                for (Expense expense : expenses) {
	                    System.out.println(expense);
	                }
	                break;

	            case 3:
	                System.out.print("Enter the ID of the Expense to update: ");
	                int updateId = sc.nextInt();
	                Expense expenseToUpdate = session.get(Expense.class, updateId);
	                if (expenseToUpdate != null) {
	                    Expense updatedExpense = userInput.createExpense();
	                    
	                    expenseToUpdate.setName(updatedExpense.getName());
	                    expenseToUpdate.setCost(updatedExpense.getCost());
	                    expenseToUpdate.setColor(updatedExpense.getColor());
	                    expenseToUpdate.setUrl(updatedExpense.getUrl());
	                    expenseToUpdate.setDate(updatedExpense.getDate());
	                    updateOperation.updateExpense(expenseToUpdate, session);

	                    System.out.println("Expense updated successfully.");
	                } else {
	                    System.out.println("Expense with ID " + updateId + " not found.");
	                }
	                break;

	            case 4:
	                System.out.print("Enter the ID of the Expense to delete: ");
	                int deleteId = sc.nextInt();
	                DeleteOperation.deleteExpenseById(deleteId, session);
	                break;

	            case 5:
	                System.out.print("Enter the ID of the Expense to search: ");
	                int searchId = sc.nextInt();
	                Expense searchedExpense = session.get(Expense.class, searchId);
	                if (searchedExpense != null) {
	                    System.out.println("Found Expense:");
	                    System.out.println(searchedExpense);
	                } else {
	                    System.out.println("Expense with ID " + searchId + " not found.");
	                }
	                break;

	            case 6:
	                exit = true;
	                System.out.println("Thank you for using byeeee..........");
	                break;

	            default:
	                System.out.println("Invalid choice!!! Retry...");
	                break;
	        }
	    }

	    session.close();
	    sf.close();
	}
}
