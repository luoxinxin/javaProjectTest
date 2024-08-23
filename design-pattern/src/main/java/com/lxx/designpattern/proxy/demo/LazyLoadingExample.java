package com.lxx.designpattern.proxy.demo;

interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        // 模拟从磁盘加载图片的耗时操作
        System.out.println("Loading image: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

/**
 * 代理模式 延迟加载
 */
class ImageProxy implements Image {
    private RealImage realImage;
    private String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

public class LazyLoadingExample {
    public static void main(String[] args) {
        // 创建代理对象
        ImageProxy proxy = new ImageProxy("image.jpg");

        // 第一次调用 display 方法，触发延迟加载
        proxy.display();

        // 再次调用 display 方法，直接使用已加载的图片
        proxy.display();
    }
}
