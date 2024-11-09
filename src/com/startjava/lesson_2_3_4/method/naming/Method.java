package com.startjava.lesson_2_3_4.method.naming;

public class Method {

    public static String getNameMethod() {
        return Thread.currentThread().getStackTrace()[2].getMethodName(); 
    }
}