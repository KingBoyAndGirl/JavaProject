package com.king.BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ProjectName: Java
 * @Package: com.king.BSTCP
 * @ClassName: TCPServer
 * @Author: 王团结
 * @Description: 创建BS版本TCP服务器
 * @Date: 2019/7/29 16:31
 * @Version: 1.0
 */
public class TCPServerThread {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket和系统指定的端口号
        ServerSocket server = new ServerSocket(8080);

        while (true){
            //使用accept方法获取到请求的客户端对象（浏览器）
            Socket socket = server.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //使用Socket对象中的方法getInputStream，获取到网络字节输入流InputStream对象
                        InputStream is = socket.getInputStream();
                        //使用网络字节输入流InputStream对象中的方法read读取客户端的请求信息
                        //        byte[] bytes = new byte[1024];
                        //        int len=0;
                        //        while ((len=is.read(bytes))!=-1){
                        //            System.out.println(new String(bytes,0,len));
                        //        }
                        //把is网络字节输入流对象，转换为字符缓冲输入流
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        //把客户端请求信息的第一行读出来GET /Java/web/index.html?_ijt=drr4fim1o1grb9qad39ui9plo HTTP/1.1
                        String line = br.readLine();
                        System.out.println(line);
                        //把读取的信息进行切割，只要中间部分/Java/web/index.html?_ijt=drr4fim1o1grb9qad39ui9plo
                        String[] arr = line.split(" ");
                        //把两边不需要的去掉
                        String htmlpath = arr[1].substring(1);

                        //创建一个本地字节输入流，构造方法中绑定要读取的html路径
                        FileInputStream fis = new FileInputStream("D:\\Project\\"+htmlpath);
                        //使用Socket中的方法GetOutputStream获取网络字节输出刘OutputStream对象
                        OutputStream os = socket.getOutputStream();

                        //写入http协议响应头，固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Cotent-Type:text/html\r\n".getBytes());
                        //必须写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes());

                        //一读一写复制文件，把服务器读取的HTML文件回写到客户端
                        int len=0;
                        byte[] bytes = new byte[1024];
                        while ((len=fis.read(bytes))!=-1){
                            os.write(bytes);
                        }

                        //释放资源
                        fis.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

    }
}