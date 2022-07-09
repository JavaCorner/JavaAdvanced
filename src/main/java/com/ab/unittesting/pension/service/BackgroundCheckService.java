package com.ab.unittesting.pension.service;

import com.ab.unittesting.pension.setup.BackgroundCheckResults;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author Arpit Bhardwaj
 */
public interface BackgroundCheckService {
    BackgroundCheckResults confirm(String firstName, String lastName, String taxId, LocalDate dob) throws IOException;
}
