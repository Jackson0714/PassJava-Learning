package com.jackson0714.passjava.threads;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 演示 AtomicStampedReference ABA问题
 * @author: 悟空聊架构
 * @create: 2020-08-25
 */
public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
        // 初始化一个积木对象A，形状为三角形
        BuildingBlock A = new BuildingBlock("三角形");

        // 初始化一个积木对象B，形状为四边形，乙
        //
        // 会将三角形替换成四边形
        BuildingBlock B = new BuildingBlock("四边形");

        // 初始化一个积木对象B，形状为四边形，乙会将三边形替换成五边形
        BuildingBlock D = new BuildingBlock("五边形");


        // 创建一个原子引用类型的实例 atomicReference
        // 传递两个值，一个是初始值，一个是初始版本号
        AtomicStampedReference<BuildingBlock> atomicStampedReference = new AtomicStampedReference<>(A, 1);

        new Thread(() -> {
           // 获取版本号
           int stamp = atomicStampedReference.getStamp();
           System.out.println(Thread.currentThread().getName() + "\t 第一次版本号" + stamp);
            // 暂停线程“乙”1秒钟，使线程“甲”可以获取到原子引用的版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*
            * 乙线程开始ABA替换
            * */
           // 1.比较并替换，传入4个值，期望值A，更新值B，期望版本号，更新版本号
           atomicStampedReference.compareAndSet(A, B, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
           System.out.println(Thread.currentThread().getName() + "\t 第二次版本号" + atomicStampedReference.getStamp()); //乙	 第一次版本号1
           // 2.比较并替换，传入4个值，期望值B，更新值A，期望版本号，更新版本号
           atomicStampedReference.compareAndSet(B, A, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1); // 乙	 第二次版本号2
           System.out.println(Thread.currentThread().getName() + "\t 第三次版本号" + atomicStampedReference.getStamp()); // 乙	 第三次版本号3
        }, "乙").start();


       new Thread(() -> {
            // 获取版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号" + stamp); // 甲	 第一次版本号1
            // 暂停线程“甲”3秒钟，使线程“乙”进行一次ABA替换操作
            try {
            TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(A,D,stamp,stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t 修改成功否" + result + "\t 当前最新实际版本号：" + atomicStampedReference.getStamp()); // 甲	 修改成功否false	 当前最新实际版本号：3
            System.out.println(Thread.currentThread().getName() + "\t 当前实际最新值：" + atomicStampedReference.getReference()); // 甲	 当前实际最新值：BuildingBlock{shape='三角形}

       }, "甲").start();

    }
}
