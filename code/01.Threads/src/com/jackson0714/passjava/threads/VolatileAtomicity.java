package com.jackson0714.passjava.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 演示volatile 不保证原子性
 * @author: 悟空聊架构
 * @create: 2020-08-13
 */

public class VolatileAtomicity {
    public static volatile int number = 0;

    public synchronized static void increase() {
        number++;
    }

    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.getAndIncrement();
                }
            }, String.valueOf(i)).start();
        }

        // 当所有累加线程都结束
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(atomicInteger);
    }
}
