package com.jackson0714.passjava.threads;
import java.util.concurrent.atomic.AtomicInteger;
/**
 演示CAS compareAndSet 比较并交换
 * @author: 悟空聊架构
 * @create: 2020-08-17
 */
public class CASDemo {
    public static void  main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        Boolean result1 = atomicInteger.compareAndSet(10,20);
        System.out.printf("当前atomicInteger变量的值:%d 比较结果%s\r\n", atomicInteger.get(), result1);
        Boolean result2 = atomicInteger.compareAndSet(10,30);
        System.out.printf("当前atomicInteger变量的值:%d, 比较结果%s\n" , atomicInteger.get(), result2);
    }
}
