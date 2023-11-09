package com.pblgllgs.mongo.repositories;

import com.pblgllgs.mongo.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

public interface ExpenseRepository extends MongoRepository<Expense,String> {

    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);
}
