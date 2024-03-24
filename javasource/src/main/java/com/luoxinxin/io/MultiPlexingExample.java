package com.luoxinxin.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiPlexingExample {

    public static void main(String[] args) {
        try {
            // 创建 Selector
            Selector selector = Selector.open();

            // 创建 ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8888));
            serverSocketChannel.configureBlocking(false);

            // 将 ServerSocketChannel 注册到 Selector，并监听 ACCEPT 事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server is listening on port 8888...");

            while (true) {
                // 阻塞等待事件发生
                selector.select();

                // 获取事件集合
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (key.isAcceptable()) {
                        // 接受连接事件
                        handleAccept(key, selector);
                    } else if (key.isReadable()) {
                        // 可读事件
                        handleRead(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleAccept(SelectionKey key, Selector selector) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

        // 接受新连接
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);

        // 注册新连接的 SocketChannel 到 Selector，并监听 READ 事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("Accepted new connection from: " + socketChannel.getRemoteAddress());
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        // 读取数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(buffer);

        if (bytesRead == -1) {
            // 客户端断开连接
            key.cancel();
            socketChannel.close();
            System.out.println("Connection closed by client");
        } else if (bytesRead > 0) {
            // 处理读取到的数据
            buffer.flip();
            byte[] data = new byte[buffer.remaining()];
            buffer.get(data);
            String message = new String(data);
            System.out.println("Received message: " + message);
        }
    }
}

