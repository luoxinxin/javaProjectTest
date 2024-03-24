package com.luoxinxin.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NonBlockingNIOExample {

    public static void main(String[] args) {
        try {
            // 从文件获取输入通道
            FileInputStream fileInputStream = new FileInputStream("input.txt");
            FileChannel inputChannel = fileInputStream.getChannel();

            // 创建输出文件及输出通道
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            FileChannel outputChannel = fileOutputStream.getChannel();

//            // 将通道设置为非阻塞模式
//            inputChannel.configureBlocking(false);
//            outputChannel.configureBlocking(false);

            // 使用 ByteBuffer 进行数据传输
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                // 清空缓冲区，为新数据读取做准备
                buffer.clear();

                // 从输入通道读取数据到缓冲区，非阻塞
                int bytesRead = inputChannel.read(buffer);

                // 检查是否到达文件末尾
                if (bytesRead == -1) {
                    break;
                }

                // 切换为读模式，准备将数据写入输出通道
                buffer.flip();

                // 将数据从缓冲区写入输出通道，非阻塞
                while (buffer.hasRemaining()) {
                    outputChannel.write(buffer);
                }
            }

            // 关闭通道
            inputChannel.close();
            outputChannel.close();

            // 关闭流
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
