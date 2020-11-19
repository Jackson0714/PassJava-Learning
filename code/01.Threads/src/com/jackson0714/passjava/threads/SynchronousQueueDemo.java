package com.jackson0714.passjava.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 悟空聊架构 | PassJava666
 * @Date: 2020/9/8
 * @Site: www.passjava.cn
 * @Github: https://github.com/Jackson0714
 */
public class SynchronousQueueDemo {
    private static BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put A ");
                synchronousQueue.put("A");

                System.out.println(Thread.currentThread().getName() + "\t put B ");
                synchronousQueue.put("B");

                System.out.println(Thread.currentThread().getName() + "\t put C ");
                synchronousQueue.put("C");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take A ");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take B ");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronousQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take C ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
