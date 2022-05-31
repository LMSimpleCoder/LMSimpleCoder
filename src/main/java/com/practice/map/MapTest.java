package com.practice.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoming
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(4);
        map.put(null, "111111");
        System.out.println(map.get(null));
    }

}
