package com.king.enhancedLandLords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: Java
 * @Package: com.king.enhancedLandLords
 * @ClassName: DouDiZhu
 * @Author: 王团结
 * @Description: 斗地主有序版本
 * @Date: 2019/7/26 10:20
 * @Version: 1.0
 */
public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //创建Map集合，存储牌的索引和组装好的牌
        HashMap<Integer, String> poker = new HashMap<>();
        //创建一个List集合，存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合，存储花色和牌的序号
        List<String> colors = List.of("♠", "♥", "♣", "♦");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //把大王和小王存储到集合中
        //定义一个牌的索引
        int index=0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;
        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;
        //循环嵌套遍历两个集合，组装52张牌，存储到集合中
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index,color+number);
                pokerIndex.add(index);
                index++;
            }
        }

        //2.洗牌
        Collections.shuffle(pokerIndex);

        //3.发牌
        //定义4个集合，存储玩家牌的索引和底牌的索引
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        //遍历存储牌索引的list集合，获取每个牌的索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            //轮流发牌
            if (i>51){
                //给底牌发牌
                diPai.add(in);
            }else if(i % 3==0){
                //发玩家01发牌
                player01.add(in);
            }else if(i % 3==1){
                //发玩家02发牌
                player02.add(in);
            }else if(i % 3==2){
                //发玩家03发牌
                player03.add(in);
            }
        }

        //4.排序
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(diPai);

        //5.看牌
        lookPoker("刘德华",poker,player01);
        lookPoker("周润发",poker,player02);
        lookPoker("周星驰",poker,player02);
        lookPoker("底牌",poker,diPai);

    }

    private static void lookPoker(String name, HashMap<Integer, String> poker, ArrayList<Integer> list) {
        //输出玩家名称，不换行
        System.out.print(name+"：");
        //遍历玩家或者底牌集合，获取牌的索引
        for (Integer key : list) {
            //使用牌的索引，去Map集合中，找到对应的牌
            String value = poker.get(key);
            System.out.print(value+" ");
        }
        System.out.println();
    }


}
