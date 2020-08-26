package com.jackson0714.passjava.threads;

import java.util.ArrayList;

/**
 * @Author: 悟空聊架构| PassJava666
 * @Date: 2020/8/26 22:22
 * @Site: www.jayh.club
 * @Github: https://github.com/Jackson0714
 */
public class ArrayListDemo {
    public static void main(String args[]) {
        demo1();
    }


    public static void demo1() {
        ArrayList<BuildingBlock> arrayList = new ArrayList<>();
        arrayList.add(new BuildingBlock("三角形"));
        arrayList.add(new BuildingBlock("五角星"));
        arrayList.add(new BuildingBlock("五边形"));
        arrayList.add(new BuildingBlock("菱形"));
        arrayList.add(new BuildingBlock("三角形"));
        arrayList.add(new BuildingBlock("六角形"));

        for (BuildingBlock buildingBlock : arrayList) {
            System.out.println(buildingBlock.toString());
        }
    }
}
