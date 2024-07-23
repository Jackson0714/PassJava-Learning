package com.jackson0714.passjava.threads;
import java.util.concurrent.TimeUnit;
/**
 * Volatile Java虚拟机提供的轻量级同步机制
 *
 * 可见性（及时通知）
 * 不保证原子性
 * 禁止指令重排
 * @author: 悟空聊架构
 * @create: 2020-08-12
 */


class ShareData1 {
    //volatile 修饰的关键字，是为了增加多个线程之间的可见性，只要有一个线程修改了内存中的值，其它线程也能马上感知
    volatile int number = 0;

    public void setNumberTo100() {
        this.number = 100;
    }
}

/**
 * 验证volatile的可见性
 * 1. 假设int number = 0， number变量之前没有添加volatile关键字修饰，没有可见性
 * 2. 添加了volatile，可以解决可见性问题
 */
public class VolatileVisibility {
    public static void main(String[] args) {
        // 资源类
        ShareData1 shareData = new ShareData1();
        System.out.println(System.identityHashCode(shareData.number));

        // 子线程 实现了Runnable接口的，lambda表达式
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t come in");

            // 线程睡眠3秒，假设在进行运算
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 修改number的值
            System.out.println(System.identityHashCode(shareData.number));
            shareData.setNumberTo100();

            // 输出修改后的值
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + shareData.number);

        }, "子线程").start();

        while(shareData.number == 0) {
            // main线程就一直在这里等待循环，直到number的值不等于零
        }

        // 按道理这个值是不可能打印出来的，因为主线程运行的时候，number的值为0，所以一直在循环
        // 如果能输出这句话，说明子线程在睡眠3秒后，更新的number的值，重新写入到主内存，并被main线程感知到了
        System.out.println(Thread.currentThread().getName() + "\t 主线程知道了 number 不等于 0");

        /**
         * 最后输出结果：
         * 子线程     come in
         * 子线程     update number value:100
         * 最后线程没有停止，并行没有输出  mission is over 这句话，说明没有用volatile修饰的变量，是没有可见性
         */
    }
}


