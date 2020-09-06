package com.jackson0714.passjava.threads;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TransferQueue;

/**
 * @Author: 悟空聊架构| PassJava666
 * @Date: 2020/9/5 13:32
 * @Site: www.jayh.club
 * @Github: https://github.com/Jackson0714
 */
public class QueueDemo {

    public static void main(String[] args) {
        //ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
        LinkedBlockingDeque queue = new LinkedBlockingDeque();
        queue.addFirst("test1");
        queue.addFirst(300);
        queue.addLast("400");

        queue.add(100);
        queue.add(200);

        //TransferQueue;
        //int a = queue.peek();
//        PriorityQueue;
//        Deque;
//        LinkedBlockingDeque;

    }
}
