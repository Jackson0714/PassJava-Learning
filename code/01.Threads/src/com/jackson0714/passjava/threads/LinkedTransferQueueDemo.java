package com.jackson0714.passjava.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 悟空聊架构 | PassJava666
 * @Date: 2020/9/8
 * @Site: www.passjava.cn
 * @Github: https://github.com/Jackson0714
 */
public class LinkedTransferQueueDemo {
    private static LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t transfer A ");
                linkedTransferQueue.transfer("A");

                System.out.println(Thread.currentThread().getName() + "\t transfer B ");
                linkedTransferQueue.transfer("B");

                System.out.println(Thread.currentThread().getName() + "\t transfer C ");
                linkedTransferQueue.transfer("C");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者1").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t transfer D ");
                linkedTransferQueue.transfer("D");

                System.out.println(Thread.currentThread().getName() + "\t transfer E ");
                linkedTransferQueue.transfer("E");

                System.out.println(Thread.currentThread().getName() + "\t transfer F ");
                linkedTransferQueue.transfer("F");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者2").start();

        new Thread(() -> {
            try {
                String removedElement = "";
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                removedElement = linkedTransferQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take " + removedElement);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                removedElement = linkedTransferQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take " + removedElement);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                removedElement = linkedTransferQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take " + removedElement);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者").start();


    }
}
