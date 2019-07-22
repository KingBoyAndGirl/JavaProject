package com.king.giveRedEnvelopes;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Java
 * @Package: com.king.giveRedEnvelopes
 * @ClassName: Manager
 * @Author: 王团结
 * @Description: 群主
 * @Date: 2019/7/22 20:56
 * @Version: 1.0
 */
public class Manager extends User {

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalManey,int count){
        //首先需要一个集合，用来存储若干个红包的余额
        ArrayList<Integer> redList = new ArrayList<>();

        //首先看一下群主自己有多少钱
        int leftMoney = super.getMoney();   //群主当前余额
        if(totalManey>leftMoney){
            System.out.println("余额不足");
            return  redList; //返回一个空集合
        }

        //扣钱，其实就是重新设置余额
        super.setMoney(leftMoney-totalManey);

        //发红包需要平均拆分为count份
        int avg = totalManey / count;
        int mod=totalManey%count;       //余数，也就是甩下的零头
        // 剩下的零头，包在最后一个红包当中
        //下面把红包一个一个放到集合当中
        for (int i=0;i<count-1;i++){
            redList.add(avg);
        }
        //最后一个红包
        int last=avg+mod;
        redList.add(last);


        return redList;
    }
}
