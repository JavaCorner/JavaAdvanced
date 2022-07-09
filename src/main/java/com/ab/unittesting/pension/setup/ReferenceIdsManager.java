package com.ab.unittesting.pension.setup;

import java.time.LocalDate;

/**
 * @author Arpit Bhardwaj
 */
public interface ReferenceIdsManager {
    //String obtainId(String firstName, String lastName, String taxId, LocalDate dob);

    String obtainId(String firstName, String middleName, String lastName, String taxId, LocalDate dob);
}
