package com.luoxinxin.test;

import lombok.Data;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class IOTest {
    public static void main(String[] args) {

    }


}

/**
 * AIO read
 */
class ReadFromFile {
    public static void main(String[] args) throws Exception {
        Path file = Paths.get("./a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
        ByteBuffer buffer = ByteBuffer.allocate(100_000);
        Future<Integer> result = channel.read(buffer, 0);
        while (!result.isDone()) {
            ProfitCalculator.calculateTax();
        }
        Integer bytesRead = result.get();
        System.out.println("Bytes read [" + bytesRead + "]");
    }
}

class ProfitCalculator {
    public ProfitCalculator() {
    }

    public static void calculateTax() {
    }
}

/**
 * AIO write
 */
class WriteToFile {
    public static void main(String[] args) throws Exception {
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Paths.get("/asynchronous.txt"),
                StandardOpenOption.READ,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE
        );
        CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("Attachment: " + attachment + " " + result
                        + " bytes written");
                System.out.println("CompletionHandler Thread ID: "
                        + Thread.currentThread().getId());
            }

            @Override
            public void failed(Throwable e, Object attachment) {
                System.err.println("Attachment: " + attachment + " failed with:");
                e.printStackTrace();
            }
        };
        System.out.println("Main Thread ID: " + Thread.currentThread().getId());
        fileChannel.write(ByteBuffer.wrap("Sample".getBytes()), 0, "First Write", handler);
        fileChannel.write(ByteBuffer.wrap("Box".getBytes()), 0, "Second Write", handler);
    }
}

class nio {
    static void readNIO() {
        String pathname = "C:\\Users\\adew\\Desktop\\jd-gui.cfg";
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(pathname);
            FileChannel channel = fin.getChannel();
            int capacity = 100;// 字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());
            int length = -1;
            while ((length = channel.read(bf)) != -1) {
                // 注意，读取后，将位置置为 0，将 limit 置为容量, 以备下次读入到字节缓冲中，从 0 开始存储
                bf.clear();
                byte[] bytes = bf.array();
                System.out.write(bytes, 0, length);
                System.out.println();
                System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());
            }
            channel.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void writeNIO() {
        String filename = "out.txt";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            FileChannel channel = fos.getChannel();
            ByteBuffer src = Charset.forName("utf8").encode("你好你好你好你好你好");
            // 字节缓冲的容量和 limit 会随着数据长度变化，不是固定不变的
            System.out.println("初始化容量和 limit：" + src.capacity() + "," + src.limit());
            int length = 0;
            while ((length = channel.write(src)) != 0) {
                //注意，这里不需要 clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
                System.out.println("写入长度:" + length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class io {

    public void ioTest() {
        //Initializes The Object
        User1 user = new User1();
        user.setName("hollis");
        user.setAge(23);
        System.out.println(user);

        //Write Obj to File
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            IOUtils.closeQuietly(oos);
//            oos.close();
        }
        //Read Obj from File
        File file = new File("tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User1 newUser = (User1) ois.readObject();
            System.out.println(newUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //IOUtils.closeQuietly(ois);
//            try {
//                FileUtils.forceDelete(file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}

@Data
class User1{
    private String name;
    private int age;
}

