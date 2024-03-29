package com.ab.unittesting.pension.setup;

import com.ab.unittesting.pension.model.AccountOpeningStatus;
import com.ab.unittesting.pension.repository.AccountRepository;
import com.ab.unittesting.pension.service.BackgroundCheckService;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author Arpit Bhardwaj
 */
public class AccountOpeningService {

    private static final String UNACCEPTABLE_RISK_PROFILE = "HIGH";
    private BackgroundCheckService backgroundCheckService;
    private ReferenceIdsManager referenceIdsManager;
    private AccountRepository accountRepository;
    private AccountOpeningEventPublisher eventPublisher;

    public AccountOpeningService(BackgroundCheckService backgroundCheckService,
                                 ReferenceIdsManager referenceIdsManager,
                                 AccountRepository accountRepository,
                                 AccountOpeningEventPublisher eventPublisher) {
        this.backgroundCheckService = backgroundCheckService;
        this.referenceIdsManager = referenceIdsManager;
        this.accountRepository = accountRepository;
        this.eventPublisher = eventPublisher;
    }

    public AccountOpeningStatus openAccount(String firstName, String lastName, String taxId, LocalDate dob) throws IOException {
        BackgroundCheckResults backgroundCheckResults = backgroundCheckService.confirm(firstName,lastName,taxId,dob);

        if (backgroundCheckResults == null || backgroundCheckResults.getRiskProfile().equals(UNACCEPTABLE_RISK_PROFILE)){
            return AccountOpeningStatus.DECLINED;
        }else{
            String id = referenceIdsManager.obtainId(firstName,"", lastName,taxId,dob);
            if (id != null){
                accountRepository.save(id,firstName,lastName,taxId,dob,backgroundCheckResults);
                eventPublisher.notify(id);
                return AccountOpeningStatus.OPENED;
            }else {
                return AccountOpeningStatus.DECLINED;
            }
        }
    }
}
