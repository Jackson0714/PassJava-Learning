package com.jackson0714.passjava.threads;
/**
 演示volatile 单例模式应用（双边检测）
 * @author: 悟空聊架构
 * @create: 2020-08-17
 */

class VolatileSingleton {
    private static volatile VolatileSingleton instance = null;
    private VolatileSingleton() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }
    public static VolatileSingleton getInstance() {
        // 第一重检测
        if(instance == null) {
            // 锁定代码块
            synchronized (VolatileSingleton.class) {
                // 第二重检测
                if(instance == null) {
                    // 实例化对象
                    instance = new VolatileSingleton();
                }
            }
        }
        return instance;
    }
}
