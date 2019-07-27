package com.king.custom;

import java.util.Scanner;

/**
 * @ProjectName: Java
 * @Package: com.king.custom
 * @ClassName: Register
 * @Author: 王团结
 * @Description: 注册用户
 * @Date: 2019/7/26 14:20
 * @Version: 1.0
 */
public class Register {
    //1.使用数组保存已经出测过的用户名（数据库）
    static String[] usernames={"张三","李四","王五"};

    public static void main(String[] args) throws RegisterException {
        //2.使用Scanner获取用户输入的注册的用户名（前端页面）
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要注册的用户名");
        String username=sc.next();
        checkUsername(username);
    }
    //3.定义一个方法，对用户输入的注册用户名进行验证
    public static void checkUsername(String username) throws RegisterException {
        //遍历存储已经注册过用户名的数组，获取每一个用户名
        for (String name : usernames) {
            if(name.equals(username)){
                throw new RegisterException("亲，该用户已经注册");
            }
        }

        System.out.println("恭喜你注册成功");
    }
}
