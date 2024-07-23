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
        num = 1;
        flag = true;
    }
    public static void add() {
        while (flag) {
            num = num + 5;
            flag = false;
            System.out.println("num:" + num);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            add();
        },"子线程 t1");

        Thread t2 = new Thread(() -> {
            init();
        },"子线程 t2");

        t2.start();
        t1.start();
    }
}
