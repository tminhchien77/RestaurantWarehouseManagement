package com.rwm.api.service;

import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.dbresult.RGetUserByUsernamePwd;
import com.rwm.api.entities.request.GetUserByUsernamePwdPayLoad;
import com.rwm.api.repository.BranchRepository;
import com.rwm.api.repository.UserRepository;

import java.util.List;

public class UserService {

    private static UserService userService = null;
    public static UserService ins() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
    public static List<RGetUserByUsernamePwd> getUserByUsernamePwd(GetUserByUsernamePwdPayLoad req) throws Exception {
        return UserRepository.getUserByUsernamePwd(req);
    }
}
