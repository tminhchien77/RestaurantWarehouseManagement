package com.rwm.api.service;

import com.rwm.api.entities.request.PostAccountPayLoad;
import com.rwm.api.repository.AccountRepository;

public class AccountService {

    private static AccountService accountService = null;
    public static AccountService ins() {
        if (accountService == null) {
            accountService = new AccountService();
        }
        return accountService;
    }

    public static void createAccount(PostAccountPayLoad request) throws Exception {
        AccountRepository.createAccount(request);
    }
}
