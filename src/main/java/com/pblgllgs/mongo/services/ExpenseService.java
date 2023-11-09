package com.pblgllgs.mongo.services;

import com.pblgllgs.mongo.models.Expense;
import com.pblgllgs.mongo.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense updateExpense(Expense expense) {
        Expense expenseDb = expenseRepository.findById(
                expense.getId()).orElseThrow(() -> new RuntimeException("NOT_FOUND_ID: " + expense.getId()));
        expenseDb.setExpenseName(expense.getExpenseName());
        expenseDb.setExpenseAmount(expense.getExpenseAmount());
        expenseDb.setExpenseCategory(expense.getExpenseCategory());
        return expenseRepository.save(expense);
    }

    public Expense findExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException("NOT_FOUND"));
    }

    public Expense findExpenseById(String id){
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT_FOUND"));
    }

    public void deleteExpenseById(String id){
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isEmpty()) {
           throw new RuntimeException("NOT_FOUND_ID: " + id);
        }
        expenseRepository.deleteById(id);
    }
}
