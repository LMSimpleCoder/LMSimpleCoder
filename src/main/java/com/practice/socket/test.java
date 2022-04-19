package com.practice.socket;

public class test {
    public static void main(String[] args) {
        String str = "usidfhnaosd spdaksifha";

        int index = str.indexOf("i");
        System.out.println(index);
        System.out.println(str.substring(index,index + 1));
        System.out.println(str.indexOf('u', index + 1));
    }
}
