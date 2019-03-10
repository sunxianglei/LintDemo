package com.example.lintdemo;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static int stackLength = 0;
    static Object oj = new Object();

    public static void main(String[] args){
        stackOver();
    }

    private static void stackOver(){
        stackLength ++;
        try {
            stackOver();;
        }catch (Throwable e){
            System.out.println(stackLength);
        }

    }
}

