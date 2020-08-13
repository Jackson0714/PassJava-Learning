package com.jackson0714.passjava.threads;

/**
 演示volatile 禁止重排
 * @author: 悟空聊架构
 * @create: 2020-08-13
 */


public class VolatileResort {

    static int num = 0;
    static boolean flag = false;

    public static void init() {
        num= 1;
        flag = true;
    }

    public static void add() {

        while (flag) {
            flag = false;
            num = num + 100;
            System.out.println("num:" + num);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            add();
        },"子线程").start();
        init();

    }
}
