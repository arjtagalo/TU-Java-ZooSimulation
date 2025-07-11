package com.example.ooput.utils;

import com.example.ooput.modules.AdminModule;

public class ZooAccessUtil {

    public static boolean isZooOpen(AdminModule adminModule, String featureName) {
        if (!adminModule.isZooOpen()) {
            System.out.println(featureName + " is currently unavailable. Zoo is closed.");
            return false;
        }
        return true;
    }
}

