package com.hdv.api.service;

import com.hdv.api.entities.request.PostAccountPayLoad;
import com.hdv.api.handlers.write.PostAccountHandler;
import com.hdv.api.repository.AccountRepository;
import com.hdv.api.repository.RoleRepository;

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
