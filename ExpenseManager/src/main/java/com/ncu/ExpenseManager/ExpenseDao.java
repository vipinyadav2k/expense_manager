package com.ncu.ExpenseManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ExpenseDao {
    private final SessionFactory sessionFactory;

    public ExpenseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addExpense(Expense expense) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(expense);
            transaction.commit();
        }
    }

    public Expense getExpense(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Expense.class, id);
        }
    }

    public void updateExpense(Expense expense) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(expense);
            transaction.commit();
        }
    }

    public void deleteExpense(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Expense expense = session.get(Expense.class, id);
            if (expense != null) {
                session.delete(expense);
                transaction.commit();
            }
        }
    }
}

