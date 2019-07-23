package com.king.enhancedRedEnvelopes.scene;

import com.king.enhancedRedEnvelopes.red.OpenMode;

/**
 * @ProjectName: Java
 * @Package: com.king.enhancedRedEnvelopes
 * @ClassName: Bootstrap
 * @Author: 王团结
 * @Description:   红包分发的策略：
 *                      1.普通红包（平均）：totalMoney / totalCount，余数放在最后一个红包当中
 *                      2.手气红包（随机）：最少1分线，最多不超过平均数的2倍。
 * @Date: 2019/7/23 20:00
 * @Version: 1.0
 */
public class Bootstrap {

    public static void main(String[] args) {
        MyRed myRed = new MyRed("www.kingMo.com");
        //设置群主名称
        myRed.setOwnerName("王思聪");

//        //普通红包
//        NormalMode normalMode = new NormalMode();
//        myRed.setOpenWay(normalMode);
//
        // 手气红包
        OpenMode random = new RandomMode();
        myRed.setOpenWay(random);
    }

}
