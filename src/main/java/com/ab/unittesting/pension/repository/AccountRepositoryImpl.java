package com.ab.unittesting.pension.repository;

import com.ab.unittesting.pension.model.Account;
import com.ab.unittesting.pension.setup.BackgroundCheckResults;

import java.time.LocalDate;

/**
 * @author Arpit Bhardwaj
 */
public class AccountRepositoryImpl implements AccountRepository{
    @Override
    public boolean save(String id, String firstName, String lastName, String taxId, LocalDate dob, BackgroundCheckResults backgroundCheckResults) {
        return false;
    }

    @Override
    public boolean isExpired(Account account) {
        return false;
    }
}
