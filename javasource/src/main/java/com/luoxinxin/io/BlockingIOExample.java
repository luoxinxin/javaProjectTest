package com.luoxinxin.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BlockingIOExample {

    public static void main(String[] args) {
        try {
            // 从文件读取数据
            InputStream inputStream = new FileInputStream("input.txt");

            // 创建输出文件
            OutputStream outputStream = new FileOutputStream("output.txt");

            // 读取和写入数据
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                // 阻塞读取数据
                outputStream.write(buffer, 0, bytesRead); // 阻塞写入数据
            }

            // 关闭流
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

