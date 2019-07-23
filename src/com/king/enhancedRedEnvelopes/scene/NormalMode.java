package com.king.enhancedRedEnvelopes.scene;

import com.king.enhancedRedEnvelopes.red.OpenMode;

import java.util.ArrayList;

/**
 * @ProjectName: Java
 * @Package: com.king.enhancedRedEnvelopes.scene
 * @ClassName: NormalMode
 * @Author: 王团结
 * @Description: 分均分发
 * @Date: 2019/7/23 21:21
 * @Version: 1.0
 */
public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney,final int totalCount) {
        ArrayList<Integer> list=new ArrayList<Integer>();

        //发红包需要平均拆分为count份
        int avg = totalMoney / totalCount;
        int mod=totalMoney%totalCount;       //余数，也就是甩下的零头
        // 剩下的零头，包在最后一个红包当中
        //下面把红包一个一个放到集合当中
        for (int i=0;i<totalCount-1;i++){
           list.add(avg);
        }
        //最后一个红包
        int last=avg+mod;
        list.add(last);


        return list;

    }
}
