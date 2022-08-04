package com.example.router.mapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于生成最终Mapping文件的 示例
 * 右键 点击 ASM Bytecode Viewer 可查看字节码
 */
public class RouterMapping {

    public static Map<String,String> get(){
        Map<String,String> map = new HashMap<>();
        map.putAll(RouterMapping_1.get());
        map.putAll(RouterMapping_2.get());

        return map;
    }
}
