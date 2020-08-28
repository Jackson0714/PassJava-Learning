package com.jackson0714.passjava.threads;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;

/**
 * 积木类
 * @author: 悟空聊架构
 * @create: 2020-08-27
 */
class BuildingBlockWithName {
    String shape;
    String name;
    public BuildingBlockWithName(String shape, String name) {
        this.shape = shape;
        this.name = name;
    }
    @Override
    public String toString() {
        return "BuildingBlockWithName{" + "shape='" + shape + ",name=" + name +'}';
    }
}

/**
 * @Author: 悟空聊架构| PassJava666
 * @Date: 2020/8/26 22:22
 * @Site: www.jayh.club
 * @Github: https://github.com/Jackson0714
 */
public class ArrayListDemo {
    public static void main(String args[]) {
        vectorDemo();
    }

    /**
     * Description: 验证单线程下ArrayList线程是安全的
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/27
     * @Site: www.jayh.club
     * @Github: https://github.com/Jackson0714
     */
    public static void demo1() {
        ArrayList<BuildingBlockWithName> arrayList = new ArrayList<>();
        arrayList.add(new BuildingBlockWithName("三角形", "A"));
        arrayList.add(new BuildingBlockWithName("四边形", "B"));
        arrayList.add(new BuildingBlockWithName("五边形", "C"));
        arrayList.add(new BuildingBlockWithName("六边形", "D"));
        arrayList.add(new BuildingBlockWithName("五角星", "E"));

        arrayList.add(new BuildingBlockWithName("6角星", "F"));
        arrayList.add(new BuildingBlockWithName("7角星", "G"));
        arrayList.add(new BuildingBlockWithName("8角星", "H"));
        arrayList.add(new BuildingBlockWithName("9角星", "I"));
        arrayList.add(new BuildingBlockWithName("10角星", "J"));
        arrayList.add(new BuildingBlockWithName("11角星", "K"));

        for (BuildingBlockWithName buildingBlockWithName : arrayList) {
            System.out.println(buildingBlockWithName.toString());
        }
    }

    /**
     * Description: 验证多线程下ArrayList线程不安全
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/27
     * @Site: www.jayh.club
     * @Github: https://github.com/Jackson0714
     */
    public static void demo2() {
        ArrayList<BuildingBlockWithName> arrayList = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            new Thread(() -> {
                Random random = new Random();
                int type = random.nextInt(4); // 随机生成0/1/2/3/4
                switch(type) {
                    case 0: arrayList.add(new BuildingBlockWithName("三角形", "A"));
                        break;
                    case 1:  arrayList.add(new BuildingBlockWithName("四边形", "B"));
                        break;
                    case 2: arrayList.add(new BuildingBlockWithName("五边形", "C"));
                        break;
                    case 3: arrayList.add(new BuildingBlockWithName("六边形", "D"));
                        break;
                    case 4: arrayList.add(new BuildingBlockWithName("五角星", "E"));
                        break;
                }
                System.out.println(arrayList);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * Description: 验证多线程下ArrayList线程不安全
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/28
     * @Site: www.jayh.club
     * @Github: https://github.com/Jackson0714
     */
    public static void vectorDemo() {
        Vector<BuildingBlockWithName> arrayList = new Vector<>(5,3);
        for(int i = 0; i < 20; i++) {
            new Thread(() -> {
                Random random = new Random();
                int type = random.nextInt(4); // 随机生成0/1/2/3/4
                switch(type) {
                    case 0: arrayList.add(new BuildingBlockWithName("三角形", "A"));
                        break;
                    case 1:  arrayList.add(new BuildingBlockWithName("四边形", "B"));
                        break;
                    case 2: arrayList.add(new BuildingBlockWithName("五边形", "C"));
                        break;
                    case 3: arrayList.add(new BuildingBlockWithName("六边形", "D"));
                        break;
                    case 4: arrayList.add(new BuildingBlockWithName("五角星", "E"));
                        break;
                }
                System.out.println(arrayList);
            }, String.valueOf(i)).start();
        }
    }
}
