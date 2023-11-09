package com.pblgllgs.mongo.controllers;

import com.pblgllgs.mongo.models.Expense;
import com.pblgllgs.mongo.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> findAllExpenses() {
        return new ResponseEntity<>(expenseService.findAllExpenses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> findExpenseById(@PathVariable("id") String id) {
        return new ResponseEntity<>(expenseService.findExpenseById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Expense> findExpenseByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(expenseService.findExpenseByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable("id") String id) {
        expenseService.deleteExpenseById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense) {
        return new ResponseEntity<>(expenseService.updateExpense(expense), HttpStatus.OK);
    }

}
