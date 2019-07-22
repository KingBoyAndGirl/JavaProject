package com.king.giveRedEnvelopes;

/**
 * @ProjectName: Java
 * @Package: com.king.giveRedEnvelopes
 * @ClassName: User
 * @Author: 王团结
 * @Description: 用户类
 * @Date: 2019/7/22 20:50
 * @Version: 1.0
 */
public class User {
    private String name; //姓名
    private int money;  //余额，也就是当前用户拥有的钱数



    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    //展示一下当前用户有多少钱
    public void show(){
        System.out.println("姓名："+name+"余额："+money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
