package com.example.router.mapping;

import java.util.HashMap;
import java.util.Map;

public class RouterMapping {

    public static Map<String,String> get(){
        Map<String,String> map = new HashMap<>();
        map.put("router://page-kotlin", "com.*.router.demo.KtMainActivity");
        map.put("router://page-home", "com.*.router.demo.MainActivity");
        return map;
    }
}
