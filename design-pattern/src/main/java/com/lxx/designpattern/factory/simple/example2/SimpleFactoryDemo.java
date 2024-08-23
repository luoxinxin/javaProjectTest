package com.lxx.designpattern.factory.simple.example2;

// 产品接口
interface Product {
    void doSomething();
}

// 具体产品类 1
class ConcreteProduct1 implements Product {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProduct1 is doing something...");
    }
}

// 具体产品类 2
class ConcreteProduct2 implements Product {
    @Override
    public void doSomething() {
        System.out.println("ConcreteProduct2 is doing something...");
    }
}

// 工厂类
class Factory {
    // 根据传入的参数创建相应的产品对象
    public Product createProduct(String type) {
        if (type.equalsIgnoreCase("Product1")) {
            return new ConcreteProduct1();
        } else if (type.equalsIgnoreCase("Product2")) {
            return new ConcreteProduct2();
        } else {
            throw new IllegalArgumentException("Invalid product type");
        }
    }
}

public class SimpleFactoryDemo {
    public static void main(String[] args) {
        // 创建工厂对象
        Factory factory = new Factory();

        // 创建具体产品对象
        Product product1 = factory.createProduct("Product1");
        Product product2 = factory.createProduct("Product2");

        // 执行产品的方法
        product1.doSomething();
        product2.doSomething();
    }
}
