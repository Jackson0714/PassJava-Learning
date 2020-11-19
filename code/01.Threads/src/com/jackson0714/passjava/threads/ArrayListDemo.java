package com.jackson0714.passjava.threads;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

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
 * @Site: www.passjava.cn
 * @Github: https://github.com/Jackson0714
 */
public class ArrayListDemo {
    public static void main(String args[]) {
        HashSetDemo();
    }

    /**l
     * Description: 验证单线程下ArrayList是线程安全的
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/27
     * @Site: www.passjava.cn
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
     * Description: 验证多线程下ArrayList是线程不安全的
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/27
     * @Site: www.passjava.cn
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
     * Description: 验证多线程下vector是线程安全的
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/28
     * @Site: www.passjava.cn
     * @Github: https://github.com/Jackson0714
     */
    public static void vectorDemo() {
        Vector<BuildingBlockWithName> arrayList = new Vector<>();
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
     * Description: 验证多线程下Collections.synchronizedList(new ArrayList())是线程安全的
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/28
     * @Site: www.passjava.cn
     * @Github: https://github.com/Jackson0714
     */
    public static void collectionsSynchronizedListDemo() {
        List<Object> arrayList = Collections.synchronizedList(new ArrayList<>());
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
     * Description: 验证多线程下CopyOnWriteArrayList是线程安全的
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/28
     * @Site: www.passjava.cn
     * @Github: https://github.com/Jackson0714
     */
    public static void CopyOnWriteArrayListDemo() {
        CopyOnWriteArrayList<BuildingBlockWithName> arrayList = new CopyOnWriteArrayList<>();
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
     * Description: HashSet的使用
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/29 - 00:40
     * @Site: www.passjava.cn
     * @Github: https://github.com/Jackson0714
     */
    public static void HashSetDemo() {
        Set<BuildingBlockWithName> set1 = new HashSet<>();
        //set1.add("a");
        Set<BuildingBlockWithName> set2 = Collections.synchronizedSet(new HashSet<>());
        CopyOnWriteArraySet<BuildingBlockWithName> set3 = new CopyOnWriteArraySet<>();
    }

    /**
     * Description: HashMap的使用
     * @Author: 公众号 | 悟空聊架构 | PassJava666
     * @Date: 2020/8/29 - 00:40
     * @Site: www.passjava.cn
     * @Github: https://github.com/Jackson0714
     */
    public static void HashMapDemo() {
        Map<String, BuildingBlockWithName> map1 = new HashMap<>();
        map1.put("A", new BuildingBlockWithName("三角形", "A"));

        Map<String, BuildingBlockWithName> map2 = Collections.synchronizedMap(new HashMap<>());

        ConcurrentHashMap<String, BuildingBlockWithName> map3 = new ConcurrentHashMap<>();
        map3.put("A", new BuildingBlockWithName("三角形", "A"));
    }

}
