package com.rwm.api.service;

import com.rwm.api.dbresult.RGetRole;
import com.rwm.api.repository.RoleRepository;

import java.util.List;

public class RoleService {

    private static RoleService roleService = null;
    public static RoleService ins() {
        if (roleService == null) {
            roleService = new RoleService();
        }
        return roleService;
    }
    public static List<RGetRole> getAllRole() throws Exception {
        return RoleRepository.getAllRole();
    }
}
