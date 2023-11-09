package com.pblgllgs.mongo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * @author pblgl
 * Created on 08-11-2023
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "expenses")
public class Expense {
    @Id
    private String id;
    @Indexed(unique = true)
    @Field(name = "name")
    private String expenseName;
    @Field(name = "category")
    private ExpenseCategory expenseCategory;
    @Field(name = "amount")
    private BigDecimal expenseAmount;
}
