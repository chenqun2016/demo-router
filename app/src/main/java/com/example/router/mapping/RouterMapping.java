package com.example.router.mapping;

import java.util.HashMap;
import java.util.Map;

public class RouterMapping {

    public static Map<String,String> get(){
        Map<String,String> map = new HashMap<>();
        map.putAll(RouterMapping_1.get());
        map.putAll(RouterMapping_2.get());

        return map;
    }
}
