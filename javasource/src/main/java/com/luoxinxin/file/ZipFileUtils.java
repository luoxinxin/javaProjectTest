package com.luoxinxin.file;

import java.io.*;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileUtils {


    public static void compressFiles(File[] files, String zipPath) throws IOException {
        FileOutputStream f = new FileOutputStream(zipPath);
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zipOut = new ZipOutputStream(checkedOutputStream);
        BufferedOutputStream buffOut = new BufferedOutputStream(zipOut);
        zipOut.setComment("zip test");
        for (File file : files) {
            BufferedReader bfReader = new BufferedReader(new FileReader(file));
            zipOut.putNextEntry(new ZipEntry(file.getName()));

            int c;
            while ((c = bfReader.read()) != -1) {
                buffOut.write(c);
            }
            bfReader.close();
            buffOut.flush();
        }
        buffOut.close();
    }

    public static void main(String[] args) throws IOException {
        String dir = "d:";
        String zipPath = "d:/test.zip";
        //File[] files = Directory.getLocalFiles(dir, ".*\\.txt");
        //ZipFileUtils.compressFiles(files, zipPath);
    }
}
