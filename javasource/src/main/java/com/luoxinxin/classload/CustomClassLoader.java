package com.luoxinxin.classload;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * 自定义类加载器破坏双亲委派机制
 */
public class CustomClassLoader extends ClassLoader {

    public CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        // 检查是否已经加载过该类
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass != null) {
            return loadedClass;
        }

        // 自定义加载逻辑
        if (name.startsWith("java.")) {
            // 对于以 "java." 开头的类，使用双亲委派机制加载
            return super.loadClass(name);
        }

        try {
            // 从指定路径加载类
            byte[] classData = getClassData(name);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            // 若加载失败，则抛出 ClassNotFoundException
            throw new ClassNotFoundException(name, e);
        }
    }

    private byte[] getClassData(String className) throws IOException {
        // 根据类名加载类的字节码数据
        String classPath = className.replace('.', '/') + ".class";
        try (FileInputStream fis = new FileInputStream(classPath);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            return bos.toByteArray();
        }
    }

    public static void main(String[] args) {
        // 使用自定义类加载器加载类
        CustomClassLoader classLoader = new CustomClassLoader(ClassLoader.getSystemClassLoader());
        try {
            Class<?> clazz = classLoader.loadClass("com.luoxinxin.domain.Person");
            // 创建对象并调用方法
            Object instance = clazz.newInstance();
//            clazz.getMethod("someMethod").invoke(instance);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
