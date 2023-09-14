package com.ncu.ExpenseManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteOperation {
    public static void deleteExpenseById(int id, Session session) {
        // Check if the Expense with the specified ID exists
        Expense expenseToDelete = session.get(Expense.class, id);
        if (expenseToDelete != null) {
            Transaction tx = session.beginTransaction();
            session.delete(expenseToDelete);
            tx.commit();
            System.out.println("Expense with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Expense with ID " + id + " not found.");
        }
    }
}

