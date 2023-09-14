package com.ncu.ExpenseManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CreateOperation {
    public void insertExpense(Expense expense, Session session) {
        Transaction tx = session.beginTransaction();
        session.save(expense);
        tx.commit();
    }
}
