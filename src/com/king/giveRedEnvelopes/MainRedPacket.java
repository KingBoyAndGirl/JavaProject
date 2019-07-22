package com.king.giveRedEnvelopes;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Java
 * @Package: com.king.giveRedEnvelopes
 * @ClassName: MainRedPacket
 * @Author: 王团结
 * @Description: 群
 * @Date: 2019/7/22 21:25
 * @Version: 1.0
 */
public class MainRedPacket {
    public static void main(String[] args) {
        Manager manager = new Manager("群主", 100);

        Member one = new Member("成员A", 0);
        Member two = new Member("成员B", 0);
        Member three = new Member("成员C", 0);

        manager.show();
        one.show();
        two.show();
        three.show();
        System.out.println("=====================");


        //群主总共发20块钱，分成3个红包

        ArrayList<Integer> redList = manager.send(20, 3);

        one.recerive(redList);
        two.recerive(redList);
        three.recerive(redList);


        manager.show();
        one.show();
        two.show();
        three.show();
    }
}
