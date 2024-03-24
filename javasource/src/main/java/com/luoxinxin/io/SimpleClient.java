package com.luoxinxin.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int serverPort = 12345;

        try {
            // 创建 Socket，连接服务器
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server: " + serverAddress);

            // 获取输出流
            OutputStream outputStream = socket.getOutputStream();

            // 发送数据给服务器
            String message = "Hello, Server!";
            byte[] messageBytes = message.getBytes();
            outputStream.write(messageBytes);
            System.out.println("Sent message to server: " + message);

            // 关闭连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

