package com.king.custom;

/**
 * @ProjectName: Java
 * @Package: com.king.custom
 * @ClassName: RegisterException
 * @Author: 王团结
 * @Description: 自定义登录异常
 * @Date: 2019/7/26 14:09
 * @Version: 1.0
 */
public class RegisterException extends Exception{
    //添加一个空参数构造
    public RegisterException(){
        super();
    }

    /**
     * 查看源码发现，所有的异常类都会有一个带异常信息的构造方法，方法内部会调用父类带异常信息的构造方法，让父类来处理这个异常信息。
     */
    public RegisterException(String message){
        super(message);
    }
}
