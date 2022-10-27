package com.rwm.api.service;

import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.dbresult.RGetDish;
import com.rwm.api.repository.BranchRepository;
import com.rwm.api.repository.DishRepository;

import java.util.List;

public class DishService {

    private static DishService dishService = null;
    public static DishService ins() {
        if (dishService == null) {
            dishService = new DishService();
        }
        return dishService;
    }
    public static List<RGetDish> getAllDish() throws Exception {
        return DishRepository.getAllDish();
    }
}
