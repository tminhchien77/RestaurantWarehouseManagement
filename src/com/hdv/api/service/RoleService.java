package com.hdv.api.service;

import com.hdv.api.dbresult.RGetRole;
import com.hdv.api.entities.APIRequest;
import com.hdv.api.repository.RoleRepository;

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
