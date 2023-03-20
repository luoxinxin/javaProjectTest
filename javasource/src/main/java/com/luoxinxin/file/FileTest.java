package com.luoxinxin.file;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.*;

public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D://kkk"+File.separator+"hello");
        System.out.println("file.getAbsoluteFile() = " + file.getAbsoluteFile());
        System.out.println("file.mkdir() = " + file.mkdir());
        //file.delete();
        //file.createNewFile();
        System.out.println("file.list() = " + file.list());
        file.listFiles();
        InputStream inputStream;

        System.out.println();
        System.in.read();
        String s;
        in();

        CheckedInputStream checkedInputStream;
        CheckedOutputStream checkedOutputStream;
        DeflaterOutputStream deflaterOutputStream;
        ZipOutputStream zipOutputStream;
        GZIPOutputStream gzipOutputStream;
        ZipEntry zipEntry;

    }

    /**
     * 读取控制台内容
     * @throws IOException
     */
    public static void in() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null && s.length() != 0){
            setOut(s);
        }
    }

    public static void setOut(String s) throws IOException {
        OutputStream outputStream = new FileOutputStream("D:/system.out.txt");
        PrintStream printStream = new PrintStream(outputStream);
        printStream.write(s.getBytes(StandardCharsets.UTF_8));
        System.setOut(printStream);
    }



}
