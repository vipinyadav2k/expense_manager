package com.ncu.ExpenseManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateOperation {
    public void updateExpense(Expense expense, Session session) {
        Transaction tx = session.beginTransaction();
        session.update(expense);
        tx.commit();
    }
}

