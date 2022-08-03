package com.example.router.mapping;

import java.util.HashMap;
import java.util.Map;

public class RouterMapping_1 {

    public static Map<String, String> get() {
        Map<String, String> mapping = new HashMap<>();
        mapping.put("router://page-home", "com.example.router.MainActivity");
        mapping.put("router://page-login", "com.example.router.LoginActivity");
        return mapping;
    }
}
