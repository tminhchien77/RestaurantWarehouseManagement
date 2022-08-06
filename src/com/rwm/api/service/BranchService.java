package com.rwm.api.service;

import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.dbresult.RGetRole;
import com.rwm.api.repository.BranchRepository;
import com.rwm.api.repository.RoleRepository;

import java.util.List;

public class BranchService {

    private static BranchService branchService = null;
    public static BranchService ins() {
        if (branchService == null) {
            branchService = new BranchService();
        }
        return branchService;
    }
    public static List<RGetBranch> getAllBranch() throws Exception {
        return BranchRepository.getAllBranch();
    }
}
