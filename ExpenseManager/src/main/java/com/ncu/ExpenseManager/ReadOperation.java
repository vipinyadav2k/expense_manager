package com.ncu.ExpenseManager;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ReadOperation {
    public List<Expense> getAllExpenses(Session session) {
        Query<Expense> query = session.createQuery("from Expense", Expense.class);
        return query.getResultList();
    }
}
