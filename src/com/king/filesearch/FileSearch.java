package com.king.filesearch;

import java.io.File;
import java.io.FileFilter;

/**
 * @ProjectName: Java
 * @Package: com.king.filesearch
 * @ClassName: FileSearch
 * @Author: 王团结
 * @Description: 按指定格式搜索文件
 * @Date: 2019/7/23 22:54
 * @Version: 1.0
 */
public class FileSearch {
    public static void main(String[] args) {
        File dir = new File("D:\\Project");
        printDir2(dir);
    }

    public static void printDir2(File dir) {
//        // 匿名内部类方式,创建过滤器子类对象
//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith(".java") || pathname.isDirectory();
//            }
//        });
//        //Lambda表达式优化
//        File[] files = dir.listFiles((File pathname)-> {
//            return pathname.getName().endsWith(".java") || pathname.isDirectory();
//        });

        //Lambda表达式再优化
        File[] files = dir.listFiles(pathname->pathname.getName().endsWith(".java") || pathname.isDirectory());
        // 循环打印
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                printDir2(file);
            }
        }
    }
}



