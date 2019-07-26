package com.king.landLords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: Java
 * @Package: com.king.landlords
 * @ClassName: DouDiZhu
 * @Author: 王团结
 * @Description:
 * @Date: 2019/7/25 14:24
 * @Version: 1.0
 */
public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //定义一个存储54张牌的ArrayList集合，泛型使用String
        ArrayList<String> poker = new ArrayList<>();
        //定义两个数组，一个数组存储牌的花色，一个数组存储牌的序号
        String[] colors={"♠","♥","♣","♦"};
        String[] numbers={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        //先把大王和小王存储到poker集合中
        poker.add("大王");
        poker.add("小王");
        for (String number : numbers) {
            for (String color : colors) {
                poker.add(color+number);
            }
        }


        //2.洗牌
        Collections.shuffle(poker);


        //3.发牌
        //定义4个集合，存储玩家的牌和底牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            //获取每一张牌
            String p = poker.get(i);
            //轮流发牌
            if (i>51){
                //给底牌发牌
                diPai.add(p);
            }else if(i % 3==0){
                //发玩家01发牌
                player01.add(p);
            }else if(i % 3==1){
                //发玩家02发牌
                player02.add(p);
            }else if(i % 3==2){
                //发玩家03发牌
                player03.add(p);
            }
        }

        //4.看牌
        System.out.println("刘德华："+player01);
        System.out.println("周润发："+player02);
        System.out.println("周星驰："+player03);
        System.out.println("底牌："+diPai);
    }
}
