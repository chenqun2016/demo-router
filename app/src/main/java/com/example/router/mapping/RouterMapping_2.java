package com.example.router.mapping;

import java.util.HashMap;
import java.util.Map;

public class RouterMapping_2 {

    public static Map<String, String> get() {
        Map<String, String> mapping = new HashMap<>();
        mapping.put("router://reading", "com.gradle.sample.biz.reading.ReadingActivity");
        return mapping;
    }
}
