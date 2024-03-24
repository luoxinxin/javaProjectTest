package com.luoxinxin.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {
        final int portNumber = 12345;

        try {
            // 创建 ServerSocket，监听指定端口
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is listening on port " + portNumber);

            // 接受客户端连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // 获取客户端输入流
            InputStream inputStream = clientSocket.getInputStream();
            byte[] buffer = new byte[1024];

            // 读取客户端发送的数据
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message from client: " + message);
            }

            // 关闭连接
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

