package com.jackson0714.passjava.threads;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 积木类
 * @author: 悟空聊架构
 * @create: 2020-08-25
 */
class BuildingBlock {
    String shape;
    public BuildingBlock(String shape) {
        this.shape = shape;
    }
    @Override
    public String toString() {
        return "BuildingBlock{" + "shape='" + shape + '}';
    }
}


public class AtomicReferenceDemo {
    static BuildingBlock A = new BuildingBlock("三角形");
    // 初始化一个积木对象B，形状为四边形
    static BuildingBlock B = new BuildingBlock("四边形");
    // 初始化一个积木对象D，形状为五边形
    static BuildingBlock D = new BuildingBlock("五边形");
    // 创建一个原子引用类型的实例 atomicReference
    static AtomicReference<BuildingBlock> atomicReference = new AtomicReference<>(A);

    public static void main(String[] args) {
       new Thread(() -> {// 初始化一个积木对象A，形状为三角形
           atomicReference.compareAndSet(A, B); // A->B
           atomicReference.compareAndSet(B, A); // B->A
        }, "乙").start();

       new Thread(() -> {// 初始化一个积木对象A，形状为三角形
           try {
               // 睡眠一秒，保证t1线程，完成了ABA操作
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           // 可以替换成功，因为乙线程执行了A->B->A，形状没变，所以甲可以进行替换。
           System.out.println(atomicReference.compareAndSet(A, D) + "\t" + atomicReference.get()); // true	BuildingBlock{shape='四边形}
       }, "甲").start();
    }

    public void demo1() {
        // 初始化一个积木对象A，形状为三角形
        BuildingBlock A = new BuildingBlock("三角形");

        // 初始化一个积木对象B，形状为四边形
        BuildingBlock B = new BuildingBlock("四边形");

        // 创建一个原子引用类型的实例 atomicReference
        AtomicReference<BuildingBlock> atomicReference = new AtomicReference<>();

        // 先将原子引用类的值设置为A 三角形
        atomicReference.set(A);

        // 比较并替换：当原子引用类型的值为A 三角形时，将原子引用类型的值替换为B 四边形
        System.out.println(atomicReference.compareAndSet(A, B) + "\t" + atomicReference.get().toString()); // true	BuildingBlock{shape='四边形}

        // 比较并替换：当原子引用类型的值为A 三角形时，将原子引用类型的值替换为B 四边形
        System.out.println(atomicReference.compareAndSet(A, B) + "\t" + atomicReference.get().toString()); // false	BuildingBlock{shape='四边形}，表示实际值B不等于预期值A，替换失败
    }
}


