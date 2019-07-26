package com.king.wordFrequency;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ProjectName: Java
 * @Package: com.king.wordFrequency
 * @ClassName: Statistics
 * @Author: 王团结
 * @Description: 计算一个字符串中每个字符出现次数
 * @Date: 2019/7/26 9:08
 * @Version: 1.0
 */
public class Statistics {
    public static void main(String[] args) {
        //1.获取字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = sc.next();
        //2.创建Map集合,key是字符串中的字符，value是字符的个数
        HashMap<Character, Integer> map = new HashMap<>();
        //3.遍历字符串，获取每一个字符
        for (char c : str.toCharArray()) {
            //4.使用获取到的字符，去Map集合判断key是否存在
            if (map.containsKey(c)){
                //key存在
                Integer value = map.get(c);
                value++;
                map.put(c,value);
            }else{
                //key不存在
                map.put(c,1);
            }
        }
        //5.遍历Map集合，输出结果
        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
    }
}
