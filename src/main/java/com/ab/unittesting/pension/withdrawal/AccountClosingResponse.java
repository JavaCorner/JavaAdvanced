package com.ab.unittesting.pension.withdrawal;

import com.ab.unittesting.pension.model.AccountClosingStatus;

import java.time.LocalDateTime;

/**
 * @author Arpit Bhardwaj
 */
public class AccountClosingResponse {
    private AccountClosingStatus status;
    private LocalDateTime processingDate;

    public AccountClosingResponse(AccountClosingStatus status, LocalDateTime processingDate) {
        this.status = status;
        this.processingDate = processingDate;
    }

    public AccountClosingStatus getStatus() {
        return status;
    }

    public LocalDateTime getProcessingDate() {
        return processingDate;
    }
}
