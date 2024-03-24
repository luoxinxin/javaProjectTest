package com.luoxinxin.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class MultiPlexingClient {

    public static void main(String[] args) {
        try {
            // 创建 SocketChannel
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 8888));
            socketChannel.configureBlocking(false);

            System.out.println("Connected to server...");

            // 创建输入流
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // 从控制台读取用户输入
                System.out.print("Enter message (exit to quit): ");
                String message = scanner.nextLine();

                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                // 将用户输入的消息发送到服务器
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                socketChannel.write(buffer);

                // 从服务器读取响应
                buffer.clear();
                int bytesRead = socketChannel.read(buffer);

                if (bytesRead == -1) {
                    // 服务器断开连接
                    System.out.println("Server closed the connection");
                    break;
                }

                // 处理服务器响应
                buffer.flip();
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
                String response = new String(data);
                System.out.println("Server response: " + response);
            }

            // 关闭资源
            socketChannel.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

