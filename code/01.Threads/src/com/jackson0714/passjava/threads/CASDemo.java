package com.jackson0714.passjava.threads;
import java.util.concurrent.atomic.AtomicInteger;
/**
 演示CAS compareAndSet 比较并交换
 * @author: 悟空聊架构
 * @create: 2020-08-17
 */
public class CASDemo {
    public static void  main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        Thread.sleep(100);

        new Thread(() -> {
            atomicInteger.getAndIncrement();
        }, "aaa").start();

        atomicInteger.getAndIncrement();
    }

    private static void demo() {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.getAndIncrement();
    }
}
